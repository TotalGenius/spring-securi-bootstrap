package com.example.springsecuritybootstrap.service;


import com.example.springsecuritybootstrap.entity.User;

import java.util.Optional;
import java.util.Set;

public interface UserService {
    Set<User> getAll();

    User get(Long id);

    void save(User user);

    void update(User user);

    void delete(Long id);

    Optional<User> getByUserName(String userName);

}
