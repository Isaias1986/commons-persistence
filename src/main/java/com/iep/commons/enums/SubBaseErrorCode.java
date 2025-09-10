package com.iep.commons.enums;

import org.springframework.http.HttpStatus;

public interface SubBaseErrorCode extends BaseErrorCode{
    HttpStatus getHttpStatus();
}
