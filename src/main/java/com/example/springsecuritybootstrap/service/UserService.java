package com.example.springsecuritybootstrap.service;


import com.example.springsecuritybootstrap.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAll();

    User get(Long id);

    void save(User user);

    void delete(Long id);

    Optional<User> getByUserName(String userName);
}
