package com.mrcruztech.mongodb.services.exception;

public class ObjectNotFoundException extends RuntimeException {

    private static final long serialLVersionUID = 1L;

    public ObjectNotFoundException(String msg){
        super(msg);
    }
}
