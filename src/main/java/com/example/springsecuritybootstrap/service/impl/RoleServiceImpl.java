package com.example.springsecuritybootstrap.service.impl;


import com.example.springsecuritybootstrap.entity.Role;

import com.example.springsecuritybootstrap.repository.RoleRepository;
import com.example.springsecuritybootstrap.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Set<Role> getAll() {
        return new HashSet<>(roleRepository.getAll());
    }

    @Override
    public Role getByRoleName(String roleName) {
        return roleRepository.findRoleByRoleName(roleName).get();
    }

    @Override
    public void addRole(Role role) {
        roleRepository.saveRole(role);
    }
}
