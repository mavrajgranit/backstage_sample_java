package io.learning.backstage_sample_java.controller.exception;

public class NoteNotFoundException extends NotFoundException {

    private static final String MISSING_ID = "Unable to find Note with id='%d'";

    public NoteNotFoundException(String message) {
        super(message);
    }

    public NoteNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public static NoteNotFoundException forMissingId(final Long id){
        return new NoteNotFoundException(String.format(MISSING_ID, id));
    }
}
