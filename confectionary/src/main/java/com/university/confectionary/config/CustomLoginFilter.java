package com.university.confectionary.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.university.confectionary.domain.security.AuthenticatedUser;
import com.university.confectionary.utils.JwtTokenGenerator;
import lombok.SneakyThrows;
import lombok.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CustomLoginFilter extends UsernamePasswordAuthenticationFilter {

    private final ObjectMapper objectMapper;
    private final JwtTokenGenerator jwtTokenGenerator;

    CustomLoginFilter(
        final AuthenticationManager authenticationManager,
        final ObjectMapper objectMapper,
        final JwtTokenGenerator jwtTokenGenerator
    ) {
        this.objectMapper = objectMapper;
        this.jwtTokenGenerator = jwtTokenGenerator;
        setAuthenticationManager(authenticationManager);
    }

    @SneakyThrows
    @Override
    public Authentication attemptAuthentication(final HttpServletRequest request, final HttpServletResponse response) {
        final UserCredentials userCredentials = objectMapper.readValue(request.getInputStream(), UserCredentials.class);


        System.out.println(userCredentials.getPassword());
        final UsernamePasswordAuthenticationToken authToken =
            new UsernamePasswordAuthenticationToken(userCredentials.getLogin(), userCredentials.getPassword(), List.of());

        return getAuthenticationManager().authenticate(authToken);
    }

    @SneakyThrows
    @Override
    protected void successfulAuthentication(final HttpServletRequest request, final HttpServletResponse response,
        final FilterChain chain, final Authentication auth) {

        SecurityContextHolder.getContext().setAuthentication(auth);
        final AuthenticatedUser authenticatedUser = (AuthenticatedUser) auth.getPrincipal();
        authenticatedUser.setToken(jwtTokenGenerator.generateToken(authenticatedUser));
        
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().write(objectMapper.writeValueAsString(authenticatedUser));
        response.setHeader(HttpHeaders.AUTHORIZATION, jwtTokenGenerator.generateToken(authenticatedUser));
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST,DELETE,PUT,OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");

    }

    @SneakyThrows
    @Override
    protected void unsuccessfulAuthentication(
        final HttpServletRequest request, final HttpServletResponse response, final AuthenticationException failed
    ) {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }

    @Value
    private static class UserCredentials {
        private final String login;
        private final String password;
    }

}
