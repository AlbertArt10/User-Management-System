package com.spring.studentmanagement.security.interfaces;

import com.spring.studentmanagement.controllers.requests.LoginRequest;
import com.spring.studentmanagement.dto.SignUpRequestDto;
import com.spring.studentmanagement.exceptions.AuthenticationException;
import com.spring.studentmanagement.models.AppUser;
import jakarta.servlet.http.HttpServletRequest;

public interface SecurityService {
    AppUser signIn(LoginRequest request) throws AuthenticationException;
    AppUser signUp(SignUpRequestDto signUpRequestDto);
    void logout(HttpServletRequest request);
}
