package com.spring.studentmanagement.security.interfaces;

import com.spring.studentmanagement.controllers.requests.LoginRequest;
import com.spring.studentmanagement.exceptions.AuthenticationException;
import com.spring.studentmanagement.models.AppUser;

public interface AppAuthManager {
    String INVALID_CREDENTIALS = "Invalid credentials";
    String ACCOUNT_DISABLED = "Account is disabled";

    AppUser authenticate(LoginRequest loginRequest) throws AuthenticationException;
}
