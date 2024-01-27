package com.example.springsecuritybootstrap.util;


import com.example.springsecuritybootstrap.entity.Role;
import com.example.springsecuritybootstrap.entity.User;
import com.example.springsecuritybootstrap.service.RoleService;
import com.example.springsecuritybootstrap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;


@Component
public class DBFill {
    @Autowired
    private UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostConstruct
    public void fillDB() {
        User admin = new User("admin", "admin", 33, "admin", "admin");
        User user1 = new User("user1", "user1", 31, "user1", "user1");
        User user2 = new User("user2", "user2", 21, "user2", "user2");
        User user3 = new User("user3", "user3", 23, "user3", "user3");
        User user4 = new User("user4", "user4", 41, "user4", "user4");
        User user5 = new User("user5", "user5", 25, "user5", "user5");

        Role adminRole = new Role();
        adminRole.setRole("ROLE_ADMIN");
        roleService.addRole(adminRole);
        Role userRole = new Role();
        userRole.setRole("ROLE_USER");
        roleService.addRole(userRole);

        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);

        admin.setRoles(adminRoles);

        user1.setRoles(userRoles);
        user2.setRoles(userRoles);
        user3.setRoles(userRoles);
        user4.setRoles(userRoles);
        user5.setRoles(userRoles);

        userService.save(admin);
        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
        userService.save(user4);
        userService.save(user5);

    }
}
