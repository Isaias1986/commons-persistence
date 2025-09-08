package com.iep.commons.enums;

public enum BaseGeneralErrorCode implements BaseErrorCode{


    REQUEST_VALIDATION_ERROR("Ocurrió un error en la validación de la información");

    private final String message;

    BaseGeneralErrorCode(String message){
        this.message = message;
    }


    @Override
    public String getMessage() {
        return message;
    }
}
