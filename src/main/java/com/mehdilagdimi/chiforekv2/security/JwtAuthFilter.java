package com.mehdilagdimi.chiforekv2.security;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.mehdilagdimi.chiforekv2.model.entity.User;
import com.mehdilagdimi.chiforekv2.service.UserService;
import com.mehdilagdimi.chiforekv2.util.JwtHandler;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {


    private final JwtHandler jwtHandler;
    private final UserService userService;

    private final ObjectMapper mapper;

    //Autowired is optional here because only one constructor is defined
    public JwtAuthFilter(JwtHandler jwtHandler, UserService userService, ObjectMapper mapper) {
        this.jwtHandler = jwtHandler;
        this.userService = userService;
        this.mapper = mapper;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String authHeader = request.getHeader("AUTHORIZATION");
        final String userEmail;
        final String token;
        final boolean isTokenValid;
        if(authHeader == null || !authHeader.startsWith("Bearer ")){
            System.out.println(" inside filter auh null");
            filterChain.doFilter(request,response);
            return;
        }

        //extract jwt, email and userrole
        token = authHeader.substring(7);
        userEmail = jwtHandler.extractUsername(token);
        String userRole = jwtHandler.extractRole(token);


        if(userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            User userDetails = (User) userService.loadUserByUsername(userEmail);

            if (userDetails != null) {
                System.out.println(" before validate token");
                isTokenValid = jwtHandler.validateToken(token, userDetails);

                if (isTokenValid) {
                    UsernamePasswordAuthenticationToken authenticationToken =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }

            filterChain.doFilter(request, response);
        }
    }
}
