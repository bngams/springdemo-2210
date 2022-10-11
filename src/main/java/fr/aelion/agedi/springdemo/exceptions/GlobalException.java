package fr.aelion.agedi.springdemo.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@RequiredArgsConstructor
public class GlobalException extends Exception {
    @NonNull
    private Integer code;
    @NonNull
    private String msg;

    private HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

}
