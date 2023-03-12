package com.fgieracki.Exceptions;


public class NotFoundException extends Exception{
    String message = "";
    public NotFoundException() {
        super();
    }

    public NotFoundException(String message) {
        super(message);
        this.message = message;

    }

    @Override
    public String toString() {
        return "NotFoundException{"+message+"}";
    }
}
