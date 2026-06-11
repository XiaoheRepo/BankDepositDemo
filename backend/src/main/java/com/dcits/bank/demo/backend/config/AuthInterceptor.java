package com.dcits.bank.demo.backend.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Value("${auth.token}")
    private String authToken;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("X-Auth-Token");
        if (authToken.equals(token)) {
            return true;
        }
        response.setStatus(401);
        response.getWriter().write("{\"result_code\":401,\"result_msg\":\"Unauthorized\"}");
        return false;
    }
}
