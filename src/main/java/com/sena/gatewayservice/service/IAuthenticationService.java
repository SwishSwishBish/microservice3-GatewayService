package com.sena.gatewayservice.service;

import com.sena.gatewayservice.model.User;

public interface IAuthenticationService {
    String signInAndReturnJWT(User signInRequest);
}
