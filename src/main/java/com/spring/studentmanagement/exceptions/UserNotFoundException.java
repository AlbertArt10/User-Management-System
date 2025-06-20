package com.spring.studentmanagement.exceptions;

import lombok.extern.slf4j.Slf4j;

import java.io.Serial;

@Slf4j
public class UserNotFoundException extends Exception {
    @Serial
    private static final long serialVersionUID = 5033372735590934502L;

    public UserNotFoundException(String message) {
        super(message);
        log.error(message);
    }
}
