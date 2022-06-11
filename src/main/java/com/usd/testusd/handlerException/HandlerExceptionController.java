package com.usd.testusd.handlerException;

import com.usd.testusd.exception.CurrencyException;
import com.usd.testusd.exception.model.ExceptionModel;
import feign.FeignException;
import feign.RetryableException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler(value = CurrencyException.class)
    public ResponseEntity<?> clientException(CurrencyException ex) {

        ExceptionModel exceptionModel = ExceptionModel
                .builder()
                .nameError(ex.getClass().getSimpleName())
                .messages(ex.getMessage()).httpStatus(HttpStatus.BAD_REQUEST).build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionModel);
    }

    @ExceptionHandler(value = FeignException.class)
    public ResponseEntity<?> apiIdException(FeignException ex) {

        ExceptionModel exceptionModel = ExceptionModel
                .builder()
                .nameError(ex.getClass().getSimpleName())
                .messages(ex.getMessage()).httpStatus(HttpStatus.UNAUTHORIZED).build();

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(exceptionModel);
    }

    @ExceptionHandler(value = RetryableException.class)
    public ResponseEntity<?> timeOutException(RetryableException ex) {

        ExceptionModel exceptionModel = ExceptionModel
                .builder()
                .nameError(ex.getClass().getSimpleName())
                .messages(ex.getMessage()).httpStatus(HttpStatus.REQUEST_TIMEOUT).build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionModel);
    }

}
