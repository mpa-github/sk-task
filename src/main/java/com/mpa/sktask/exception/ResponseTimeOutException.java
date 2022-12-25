package com.mpa.sktask.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.I_AM_A_TEAPOT)
public class ResponseTimeOutException extends RuntimeException {

    public ResponseTimeOutException(String message) {
        super(message);
    }
}
