package com.tweteroo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.UsersDto;
import com.tweteroo.api.service.UsersService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/auth")
public class Users {

    @Autowired
    private UsersService service;

    @PostMapping("/sign-up")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void signUp(@RequestBody UsersDto req) {
        service.signUp(req);
    }
}
