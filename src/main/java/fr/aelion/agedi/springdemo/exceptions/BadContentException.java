package fr.aelion.agedi.springdemo.exceptions;

import lombok.NonNull;

public class BadContentException extends GlobalException {

    public BadContentException() {
        super(EXCEPTION_CODES.BAD_CONTENT, "default msg");
    }

    public BadContentException(@NonNull String msg) {
        super(EXCEPTION_CODES.BAD_CONTENT, msg);
    }
}
