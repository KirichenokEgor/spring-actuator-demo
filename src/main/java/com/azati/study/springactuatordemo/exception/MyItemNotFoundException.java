package com.azati.study.springactuatordemo.exception;

public class MyItemNotFoundException extends RuntimeException {
    public MyItemNotFoundException(String message) {
        super(message);
    }
}
