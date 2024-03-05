package com.example.training.exception;

@SuppressWarnings("serial")
public class CapacityOverException extends RuntimeException {
    public CapacityOverException(String msg) {
        super(msg);
    }
}
