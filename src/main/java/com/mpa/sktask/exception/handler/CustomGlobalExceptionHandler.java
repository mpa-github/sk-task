package com.mpa.sktask.exception.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.StringJoiner;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    // Error handle for all @Valid annotations
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {
        StringJoiner stringJoiner = new StringJoiner("; ");
        ex.getBindingResult()
          .getFieldErrors()
          .forEach(error -> stringJoiner.add(error.getDefaultMessage()));
        CustomErrorResponse responseBody = new CustomErrorResponse();
        responseBody.setTimestamp(LocalDateTime.now());
        responseBody.setStatus(HttpStatus.I_AM_A_TEAPOT.value());
        responseBody.setError("I'm a teapot");
        responseBody.setMessage(stringJoiner.toString());
        responseBody.setPath(request.getDescription(false).replace("uri=", ""));
        status = HttpStatus.I_AM_A_TEAPOT;
        return new ResponseEntity<>(responseBody, headers, status);
    }

    // Error handle for a not readable http request or JSON body parse error.
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {
        CustomErrorResponse responseBody = new CustomErrorResponse();
        responseBody.setTimestamp(LocalDateTime.now());
        responseBody.setStatus(HttpStatus.I_AM_A_TEAPOT.value());
        responseBody.setError("I'm a teapot");
        responseBody.setMessage(ex.getMessage());
        responseBody.setPath(request.getDescription(false).replace("uri=", ""));
        status = HttpStatus.I_AM_A_TEAPOT;
        return new ResponseEntity<>(responseBody, headers, status);
    }
}
