package com.sena.gatewayservise.service;

import com.sena.gatewayservise.model.User;

public interface IAuthenticationService {
    String signInAndReturnJWT(User signInRequest);
}
