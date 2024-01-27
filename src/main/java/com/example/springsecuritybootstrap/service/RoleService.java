package com.example.springsecuritybootstrap.service;

import com.example.springsecuritybootstrap.entity.Role;

import java.util.Set;

public interface RoleService {
    Set<Role> getAll();


    Role getByRoleName(String roleName);

    void addRole(Role role);
}
