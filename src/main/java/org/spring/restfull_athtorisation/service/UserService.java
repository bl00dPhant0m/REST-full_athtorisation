package org.spring.restfull_athtorisation.service;

import org.spring.restfull_athtorisation.Model.User;

import java.util.Optional;

public interface UserService {
    User saveUser(User user);

    Optional<User> getUserById(long userId);

    void deleteUser(long userId);

    void updateUser(User user);
}
