package com.iep.commons.app.exception;

import com.iep.commons.app.enums.BaseErrorCode;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@Data
@EqualsAndHashCode(callSuper = true)
public class BaseCustomException extends RuntimeException{

    private final BaseErrorCode errorCode;
    private final String message;
    private final HttpStatus httpStatus;

    public BaseCustomException(BaseErrorCode errorCode, HttpStatus httpStatus){
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.message = errorCode.getMessage();
        this.httpStatus = httpStatus;
    }

    public BaseCustomException(String message,BaseErrorCode errorCode, HttpStatus httpStatus){
        super(message);
        this.errorCode = errorCode;
        this.message = message;
        this.httpStatus = httpStatus;
    }

}
