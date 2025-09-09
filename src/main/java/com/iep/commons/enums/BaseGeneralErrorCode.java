package com.iep.commons.enums;

public enum BaseGeneralErrorCode implements BaseErrorCode{

    GENERAL_ERROR_CODE("Ocurrio un error en el proceso"),
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
