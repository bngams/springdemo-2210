package fr.aelion.agedi.springdemo.exceptions;

import lombok.Data;

import java.util.Date;

// Objet métier
@Data
public class ApiError {
    private Integer code;
    private String msg;
    private Date date;
    private Integer uid;

    public ApiError(GlobalException e) {
        this.code = e.getCode();
        this.msg = e.getMsg();
        this.uid = e.hashCode();
        this.date = new Date();
    }
}
