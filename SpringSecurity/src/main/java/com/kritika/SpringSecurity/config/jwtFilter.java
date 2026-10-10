package com.kritika.SpringSecurity.config;

import com.kritika.SpringSecurity.service.JWTservice;
import com.kritika.SpringSecurity.service.Myuserdetailsservices;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Locale;

public class jwtFilter extends OncePerRequestFilter {
    @Autowired
    private JWTservice JWTservice;
    @Autowired
    ApplicationContext context;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        String token = null;
        String username = null;

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            token = authHeader.substring(7);
            username = JWTservice.extractUserName(token);
        }

        if (username != null &&
                SecurityContextHolder.getContext().getAuthentication() == null) {

            String userDetails = context.getRealPath(String.valueOf(Myuserdetailsservices.class))
                    .toUpperCase(Locale.of(username));

            if (JWTservice.validateToken(token, userDetails)) {
                
             
                    UsernamePasswordAuthenticationToken authToken =
                            new UsernamePasswordAuthenticationToken(
                                    userDetails,
                                    null

                            );
                

            }
        }

    }
}