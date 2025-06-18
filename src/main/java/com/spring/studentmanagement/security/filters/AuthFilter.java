package com.spring.studentmanagement.security.filters;

import com.spring.studentmanagement.models.AppUser;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@ConditionalOnProperty(name = "security.enabled", havingValue = "true")
@Slf4j
public class AuthFilter extends OncePerRequestFilter {
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        final String uri = request.getRequestURI();
        return uri.equals("/user-management/") ||
                uri.startsWith("/user-management/styles") ||
                uri.startsWith("/user-management/static") ||
                uri.startsWith("/user-management/scripts") ||
                uri.startsWith("/user-management/images") ||
                uri.startsWith("/user-management/webjars") ||
                uri.startsWith("/user-management/home") ||
                uri.startsWith("/user-management/auth") ||
                uri.startsWith("/user-management/errors");
    }

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {
        final HttpSession session = request.getSession();
        AppUser user = (AppUser) session.getAttribute("userPrincipal");
        if (user == null) {
            response.sendRedirect("/user-management/errors/error-401");
        }
        log.warn("user = {}", user);
        log.warn("Filter  url = {}", request.getRequestURI());

        filterChain.doFilter(request, response);
    }

}
