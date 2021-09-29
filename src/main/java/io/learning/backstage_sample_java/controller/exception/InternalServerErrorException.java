package io.learning.backstage_sample_java.controller.exception;

public class InternalServerErrorException extends ApiException {

    public InternalServerErrorException(String message) {
        super(message);
    }

    public InternalServerErrorException(String message, Throwable cause) {
        super(message, cause);
    }
}
