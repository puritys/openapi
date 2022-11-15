package com.puritys.spring.exception;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@Slf4j
@ControllerAdvice
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public final ResponseEntity<String> handleException(final RuntimeException e, WebRequest request) {
        log.error("to handle GeneralExceptionHandler");
        int code = 50001;
        int status = code / 100;
        String msg = e.getMessage();
        log.error("Exception code: {}, msg: {}", code, msg, e);
        return ResponseEntity.status(status).body(msg);
    }

}
