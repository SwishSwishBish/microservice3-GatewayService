package com.sena.gatewayservise.service;

import com.sena.gatewayservise.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    User saveUser(User user);

    Optional<User> findByUsername(String username);

    List<User> findAllUsers();
}
