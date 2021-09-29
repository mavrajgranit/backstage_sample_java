package io.learning.backstage_sample_java.controller.exception;

public abstract class ApiException extends RuntimeException {

    public ApiException(String message) {
        super(message);
        this.message = message;
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }

    private String message;
}
