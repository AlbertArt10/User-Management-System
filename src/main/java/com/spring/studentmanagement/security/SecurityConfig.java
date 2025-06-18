package com.spring.studentmanagement.security;

import com.spring.studentmanagement.security.interfaces.AppAuthManager;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class SecurityConfig {

    private final UserDetailsServiceImpls userDetailsServiceImpls;
    private final HttpServletRequest request;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AppAuthManager authenticationManager() {
        return new AppAuthenticationManagerImpl(this.userDetailsServiceImpls, this.passwordEncoder(), this.request);
    }

    @Value("${security.enabled}")
    private boolean isSecurityEnabled;

    @PostConstruct
    private void init() {
        if (!isSecurityEnabled) {
            log.warn("Security mode is disabled!");
        } else {
            log.info("Security mode is enabled!");
        }
    }
}
