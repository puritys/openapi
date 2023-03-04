package com.puritys.spring.exception;

import javax.validation.ConstraintViolationException;

import lombok.extern.slf4j.Slf4j;

import org.json.JSONObject;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public final ResponseEntity<String> handleException(final RuntimeException e, WebRequest request) {
        log.error("to handle GeneralExceptionHandler");
        int code = 50001;
        int status = code / 100;
        String msg = e.getMessage();
        JSONObject body = new JSONObject();
        body.put("error", new JSONObject()
                .put("message", msg)
                .put("code", code));

        log.error("Exception code: {}, msg: {}", code, msg, e);
        return ResponseEntity.status(status).body(body.toString());
    }

    @Override
    public final ResponseEntity<Object> handleMethodArgumentNotValid(
        final MethodArgumentNotValidException e,
        HttpHeaders headers,
        HttpStatus status_input,
        WebRequest request
    ) {
        int code = 40001;
        int status = code / 100;
        String msg = e.getMessage();
        JSONObject body = new JSONObject();
        body.put("error", new JSONObject()
                .put("message", msg)
                .put("code", code));

        log.error("handleMethodArgumentNotValid code: {}, msg: {}", code, msg, e);
        return ResponseEntity.status(status).body(body.toString());

    }

    // @Validate For Validating Path Variables and Request Parameters
    @ExceptionHandler(ConstraintViolationException.class)
    public final ResponseEntity<String> constraint(ConstraintViolationException  e) {
        int code = 40001;
        int status = code / 100;
        String msg = e.getMessage();
        JSONObject body = new JSONObject();
        body.put("error", new JSONObject()
                .put("message", msg)
                .put("code", code));

        log.error("ConstraintViolationException code: {}, msg: {}", code, msg, e);
        return ResponseEntity.status(status).body(body.toString());
    }

}
