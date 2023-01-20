package com.tweteroo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.UsersDto;
import com.tweteroo.api.service.UsersService;

@RestController
@RequestMapping("/api/auth")
public class Users {

    @Autowired
    private UsersService service;

    @PostMapping("/sign-up")
    public void signUp(@RequestBody UsersDto req) {
        service.signUp(req);
    }
}
