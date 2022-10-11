package fr.aelion.agedi.springdemo.exceptions;

import lombok.NonNull;

public class EntityNotFoundException extends GlobalException {

    public EntityNotFoundException() {
        super(EXCEPTION_CODES.ENTITY_NOT_FOUND, "default msg");
    }

    public EntityNotFoundException(@NonNull String msg) {
        super(EXCEPTION_CODES.ENTITY_NOT_FOUND, msg);
    }
}
