package com.analuciabolico.sgtccapi.v1.core.exceptions.models;

public class BusinessException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = -6773796342975824058L;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
