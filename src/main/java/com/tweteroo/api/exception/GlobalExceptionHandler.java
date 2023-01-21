package com.tweteroo.api.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { NotFoundException.class })
    protected ResponseEntity<Object> handleNotFound(NotFoundException message, WebRequest request) {
        String bodyOfResponse = "Resource Not Found";
        return handleExceptionInternal(message, bodyOfResponse,
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = { CreatedException.class })
    protected ResponseEntity<Object> handleCreated(CreatedException message, WebRequest request) {
        String bodyOfResponse = message.getMessage();
        return new ResponseEntity<>(bodyOfResponse, HttpStatus.CREATED);
    }

    @ExceptionHandler(value = { InvalidException.class })
    protected ResponseEntity<Object> handleBadRequest(InvalidException message, WebRequest request) {
        String bodyOfResponse = message.getMessage();
        return new ResponseEntity<>(bodyOfResponse, HttpStatus.BAD_REQUEST);
    }

}