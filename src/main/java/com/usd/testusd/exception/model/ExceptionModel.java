package com.usd.testusd.exception.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
@ToString
public class ExceptionModel {

    private String nameError;

    private String messages;

    private HttpStatus httpStatus;
}
