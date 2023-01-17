package com.tweteroo.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.TweetsDto;

@RestController
@RequestMapping("/api/tweets")
public class Tweets {

    @PostMapping
    public void NewTweet(@RequestBody TweetsDto req) {
        System.out.println(req.tweet());
    }

}
