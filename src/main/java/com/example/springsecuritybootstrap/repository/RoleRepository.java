package com.example.springsecuritybootstrap.repository;


import com.example.springsecuritybootstrap.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query("select r from Role r where lower(r.role) like :role")
    Optional<Role> findRoleByRole(@Param("role") String role);


}
