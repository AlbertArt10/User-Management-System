package com.spring.studentmanagement.security;

import com.spring.studentmanagement.exceptions.AuthenticationException;
import com.spring.studentmanagement.models.AppUser;
import com.spring.studentmanagement.repositories.UserRepository;
import com.spring.studentmanagement.security.interfaces.AppUserDetailsService;
import com.spring.studentmanagement.security.utils.Security;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Security
@RequiredArgsConstructor
@Slf4j
public class UserDetailsServiceImpls implements AppUserDetailsService {

    private final UserRepository userRepository;

    @Override
    public AppUser loadByUsernameOrEmail(String usernameOrEmail) throws AuthenticationException {
        return this.userRepository.findBYUsernameOrEmail(usernameOrEmail)
                .orElseThrow(() -> new AuthenticationException(USERNAME_NOT_FOUND));
    }
}
