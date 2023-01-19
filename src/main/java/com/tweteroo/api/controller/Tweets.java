package com.tweteroo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.TweetsDto;
import com.tweteroo.api.model.Tweet;
import com.tweteroo.api.repository.TweetsRepository;

@RestController
@RequestMapping("/api/tweets")
public class Tweets {

    @Autowired
    private TweetsRepository repository;

    @PostMapping
    public void NewTweet(@RequestBody TweetsDto req) {
        repository.save(new Tweet(req));
    }

}
