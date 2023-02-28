package com.spring.tennisV2.exception;

public class IllegalScorerException extends RuntimeException {
    public IllegalScorerException() {
        super();
    }

    public IllegalScorerException(String message) {
        super(message);
    }
}
