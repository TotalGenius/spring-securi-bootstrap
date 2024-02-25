package com.example.springsecuritybootstrap.repository.impl;

import com.example.springsecuritybootstrap.entity.Role;
import com.example.springsecuritybootstrap.repository.RoleRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Repository
public class RoleRepositoryImpl implements RoleRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Set<Role> getAll() {
        return new HashSet<>(entityManager
                .createQuery("select r from Role r", Role.class)
                .getResultList());
    }

    @Override
    public Optional<Role> findRoleByRoleName(String roleName) {
        return Optional.ofNullable((Role) (entityManager
                .createQuery("select r from Role r where r.role = ?1")
                .setParameter(1, roleName)
                .getResultList()
                .get(0)));
    }

    @Override
    public void saveRole(Role role) {
        entityManager.persist(role);
    }
}
