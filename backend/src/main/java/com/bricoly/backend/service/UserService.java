package com.bricoly.backend.service;

import com.bricoly.backend.domain.User;

import java.util.Optional;

public interface UserService extends GenericService<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> checkCredentials(String email, String password);
}