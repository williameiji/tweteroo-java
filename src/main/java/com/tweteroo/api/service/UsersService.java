package com.tweteroo.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.api.dto.UsersDto;
import com.tweteroo.api.model.User;
import com.tweteroo.api.repository.UsersRepository;

@Service
public class UsersService {

    @Autowired
    private UsersRepository repository;

    public User signUp(UsersDto dto) {
        return repository.save(new User(dto));
    }
}
