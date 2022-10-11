package fr.aelion.agedi.springdemo.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalAdvice {
    // @ExceptionHandler(GlobalException.class) ??
    @ExceptionHandler({ BadContentException.class, EntityNotFoundException.class})
    public ResponseEntity<ApiError> handleBadContentException(GlobalException e) {
        //return new ResponseEntity<>(new ApiError(e), HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(new ApiError(e), e.getHttpStatus());
    }
}
