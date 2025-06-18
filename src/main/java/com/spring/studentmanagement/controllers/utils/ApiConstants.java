package com.spring.studentmanagement.controllers.utils;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public final class ApiConstants {

    public static final String REDIRECT_ERROR_401 = "redirect:/errors/error-401";
    public static final String REDIRECT_ERROR_500 = "redirect:/errors/error-500";

    public static final String ATTR_ERROR_MESSAGE = "errorMessage";
}
