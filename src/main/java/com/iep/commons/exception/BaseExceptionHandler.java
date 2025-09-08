package com.iep.commons.exception;

import com.iep.commons.enums.BaseGeneralErrorCode;
import com.iep.commons.model.BaseFieldValidationError;
import com.iep.commons.model.BaseHttpResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import jakarta.validation.ConstraintViolationException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Slf4j
@ControllerAdvice
public class BaseExceptionHandler {

    public BaseExceptionHandler(){}

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseHttpResponse<List<BaseFieldValidationError>>> handleMethodNotValidException(MethodArgumentNotValidException exception){
        log.error(exception.getMessage(), exception);
        BindingResult result = exception.getBindingResult();
        List<BaseFieldValidationError> errors = result.getFieldErrors().stream().map(fieldError ->
                        BaseFieldValidationError.builder()
                                .field(fieldError.getField())
                                .message(fieldError.getDefaultMessage())
                                .build())
                .toList();
        return new ResponseEntity<>(
                BaseHttpResponse
                        .<List<BaseFieldValidationError>>builder()
                        .timeStamp(LocalDateTime.now())
                        .developerMessage("Invalid request")
                        .httpStatus(HttpStatus.BAD_REQUEST)
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .generalErrorCode(BaseGeneralErrorCode.REQUEST_VALIDATION_ERROR)
                        .data(errors)
                        .build(),HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<BaseHttpResponse<List<BaseFieldValidationError>>> handleConstraintViolationException(ConstraintViolationException exception){
        log.error(exception.getMessage(), exception);

        List<BaseFieldValidationError> errors = exception.getConstraintViolations().stream().map(fieldError ->
                        BaseFieldValidationError.builder()
                                .field(fieldError.getPropertyPath().toString())
                                .message(fieldError.getMessageTemplate())
                                .build())
                .toList();

        return new ResponseEntity<>(
                BaseHttpResponse
                        .<List<BaseFieldValidationError>>builder()
                        .timeStamp(LocalDateTime.now())
                        .developerMessage("Invalid request")
                        .httpStatus(HttpStatus.BAD_REQUEST)
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .generalErrorCode(BaseGeneralErrorCode.REQUEST_VALIDATION_ERROR)
                        .data(errors)
                        .build(),HttpStatus.BAD_REQUEST);

    }


    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public ResponseEntity<Object> handleMissingServletRequestParameterException(MissingServletRequestParameterException exception){
        log.error(exception.getMessage(), exception);
        return new ResponseEntity<>(BaseHttpResponse.builder()
                .timeStamp(LocalDateTime.now())
                .developerMessage(exception.getMessage())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .build(),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BaseCustomException.class)
    public ResponseEntity<BaseHttpResponse<Object>> handleCustomException(BaseCustomException exception){
        log.error(exception.getMessage(), exception);
        return new ResponseEntity<>(BaseHttpResponse.builder()
                .timeStamp(LocalDateTime.now())
                .developerMessage(exception.getMessage())
                .httpStatus(exception.getHttpStatus())
                .statusCode(exception.getHttpStatus().value())
                .generalErrorCode(exception.getErrorCode())
                .build(),
                exception.getHttpStatus()
        );
    }


    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handleGeneralException(Exception exception){
        UUID uuid = UUID.randomUUID();
        log.error(uuid+" internal server error", exception);
        return new ResponseEntity<>(BaseHttpResponse.builder()
                .timeStamp(LocalDateTime.now())
                .developerMessage("An error occurred, view the log code:"+uuid)
                .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

}
