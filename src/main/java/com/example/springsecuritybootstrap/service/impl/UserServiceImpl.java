package com.example.springsecuritybootstrap.service.impl;


import com.example.springsecuritybootstrap.entity.User;
import com.example.springsecuritybootstrap.repository.UserRepository;
import com.example.springsecuritybootstrap.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Set<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public User get(Long id) {
        return userRepository.getUserById(id);
    }

    @Override
    @Transactional
    public void update(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.updateUser(user);
    }

    @Override
    @Transactional
    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.saveUser(user);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userRepository.deleteUserById(id);

    }

    @Override
    public Optional<User> getByUserName(String userName) {
        return userRepository.getUserByUsername(userName);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.getUserByUsername(username);
        if (optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("user is not found");
        }
        return optionalUser.get();
    }
}
