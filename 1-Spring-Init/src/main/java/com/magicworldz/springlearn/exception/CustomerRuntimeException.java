package com.magicworldz.springlearn.exception;

public class CustomerRuntimeException extends RuntimeException {
    private static final long serialVersionUID = 4765186863829227620L;

    public CustomerRuntimeException(String message) {
        super(message);
    }

    public CustomerRuntimeException(Throwable throwable) {
        super(throwable);
    }
}