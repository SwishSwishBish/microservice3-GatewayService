package com.sena.gatewayservice.service;

import com.sena.gatewayservice.model.User;
import com.sena.gatewayservice.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public User saveUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setCreateTime(LocalDateTime.now());
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAllUsers()
    {
        return userRepository.findAll();
    }
}
