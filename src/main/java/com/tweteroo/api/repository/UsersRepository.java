package com.tweteroo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.api.model.User;

public interface UsersRepository extends JpaRepository<User, Long> {

}
