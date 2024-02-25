package com.example.springsecuritybootstrap.repository;


import com.example.springsecuritybootstrap.entity.Role;

import java.util.Optional;
import java.util.Set;

public interface RoleRepository {
    Set<Role> getAll();

    Optional<Role> findRoleByRoleName(String roleName);

    void saveRole(Role role);


}
