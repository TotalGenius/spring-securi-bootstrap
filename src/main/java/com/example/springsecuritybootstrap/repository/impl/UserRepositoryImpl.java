package com.example.springsecuritybootstrap.repository.impl;

import com.example.springsecuritybootstrap.entity.User;
import com.example.springsecuritybootstrap.repository.UserRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Set<User> getAll() {

        return new HashSet<>(entityManager.createQuery("select u from User u left join fetch u.roles", User.class).getResultList());
    }

    @Override
    public User getUserById(Long id) {
        return entityManager
                .createQuery("select u from User u left join fetch u.roles where u.id= ?1", User.class)
                .setParameter(1, id)
                .getResultList().get(0);
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void deleteUserById(Long id) {
        entityManager
                .createQuery("delete from User u where u.id= ?1")
                .setParameter(1, id)
                .executeUpdate();
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return Optional.ofNullable(entityManager
                .createQuery("select u from User u left join fetch u.roles where u.email= ?1", User.class)
                .setParameter(1, username)
                .getResultList().get(0));

    }
}
