package com.analuciabolico.sgtccapi.v1.core.exceptions;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HttpErrorExceptionHandler extends ResponseEntityExceptionHandler {
    private static final Logger LOG = Logger.getLogger(HttpErrorExceptionHandler.class.getName());

    @ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class })
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        LOG.log(Level.WARNING, "Exception Conflict: {0}", ex.toString());
        final String body = "This should be application specific" + ex.getMessage();
        return handleExceptionInternal(ex, body, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler(value = { InternalServerError.class })
    protected ResponseEntity<Object> handleInternalServerError(RuntimeException ex, WebRequest request) {
        LOG.log(Level.WARNING, "Exception Internal Server Error: {0}", ex.toString());
        final String body = "Internal server Error" + ex.getMessage();
        return handleExceptionInternal(ex, body, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(value = { NotFoundException.class })
    protected ResponseEntity<Object> handleNotFound(RuntimeException ex, WebRequest request) {
        LOG.log(Level.WARNING, "Exception Not Found Error: {0}", ex.toString());
        final String body = "Not Found Error" + ex.getMessage();
        return handleExceptionInternal(ex, body, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}