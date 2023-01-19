package com.tweteroo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.UsersDto;
import com.tweteroo.api.model.User;
import com.tweteroo.api.repository.UsersRepository;

@RestController
@RequestMapping("/api/users")
public class Users {

    @Autowired
    private UsersRepository repository;

    @PostMapping
    public void signUp(@RequestBody UsersDto req) {
        repository.save(new User(req));
    }
}
