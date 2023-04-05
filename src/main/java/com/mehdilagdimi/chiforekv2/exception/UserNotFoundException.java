package com.mehdilagdimi.chiforekv2.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(final String msg) {
        super(msg);
    }

}