package com.iep.commons.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.iep.commons.enums.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(Include.NON_NULL)
public class BaseHttpResponse<T> {

    protected LocalDateTime timeStamp;
    protected int statusCode;
    protected HttpStatus httpStatus;
    protected BaseErrorCode generalErrorCode;
    protected String message;
    protected String developerMessage;
    protected T data;
}
