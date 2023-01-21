package com.tweteroo.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.api.model.User;

public interface UsersRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
