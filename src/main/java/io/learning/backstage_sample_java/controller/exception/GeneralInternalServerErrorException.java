package io.learning.backstage_sample_java.controller.exception;

public class GeneralInternalServerErrorException extends InternalServerErrorException {

    private static final String GENERAL_ERROR = "An unexpected error occurred. Please contact an Admin.";

    public GeneralInternalServerErrorException(String message) {
        super(message);
    }

    public GeneralInternalServerErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public static GeneralInternalServerErrorException create(){
        return new GeneralInternalServerErrorException(GENERAL_ERROR);
    }

    public static GeneralInternalServerErrorException create(final Throwable e){
        return new GeneralInternalServerErrorException(GENERAL_ERROR, e);
    }
}
