package com.tweteroo.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.UsersDto;

@RestController
@RequestMapping("/api/users")
public class Users {

    @PostMapping
    public void signUp(@RequestBody UsersDto req) {
        System.out.println(req.username());
    }
}
