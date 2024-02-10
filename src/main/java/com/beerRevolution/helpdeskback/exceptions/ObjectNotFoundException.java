package com.beerRevolution.helpdeskback.exceptions;

public class ObjectNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ObjectNotFoundException(String message) {
        super(message);
    }


    //Throwable a causa do erro
    public ObjectNotFoundException(String message,Throwable cause) {
        super(message,cause);
    }
}
