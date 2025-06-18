package com.spring.studentmanagement.exceptions;

import lombok.extern.slf4j.Slf4j;

import java.io.Serial;

@Slf4j
public class AuthenticationException extends Exception {

    @Serial
    private static final long serialVersionUID = 578783969488844889L;

    public AuthenticationException(String message) {
        super(message);
        log.error(message);
    }
}
