package ru.cloudapp.authorization_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.cloudapp.authorization_service.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}