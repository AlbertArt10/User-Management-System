package com.spring.studentmanagement.controllers.requests;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Builder;

@Builder
public record LoginRequest(String usernameOrEmail, String password) {

    private static final String PARAM_USERNAME_OR_EMAIL = "usernameOrEmail";
    private static final String PARAM_PASSWORD = "password";

    public static LoginRequest getLoginRequest(HttpServletRequest request) {
        return LoginRequest.builder()
                .usernameOrEmail(request.getParameter(PARAM_USERNAME_OR_EMAIL))
                .password(request.getParameter(PARAM_PASSWORD))
                .build();
    }
}
