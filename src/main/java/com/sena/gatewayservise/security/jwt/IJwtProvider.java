package com.sena.gatewayservise.security.jwt;

import com.sena.gatewayservise.security.UserPrincipal;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

public interface IJwtProvider {
    String generateToken(UserPrincipal authentication);

    Authentication getAuthentication (HttpServletRequest request);


    boolean isTokenValid(HttpServletRequest request);
}
