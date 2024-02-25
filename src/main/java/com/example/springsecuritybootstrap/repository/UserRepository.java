package com.example.springsecuritybootstrap.repository;


import com.example.springsecuritybootstrap.entity.User;

import java.util.Optional;
import java.util.Set;

public interface UserRepository {
    Set<User> getAll();

    User getUserById(Long id);

    void saveUser(User user);

    void deleteUserById(Long id);

    Optional<User> getUserByUsername(String username);

    public void updateUser(User user);
}
