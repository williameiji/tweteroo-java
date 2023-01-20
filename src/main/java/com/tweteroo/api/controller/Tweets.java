package com.tweteroo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.TweetsDto;
import com.tweteroo.api.model.Tweet;
import com.tweteroo.api.service.TweetsService;

@RestController
@RequestMapping("/api/tweets")
public class Tweets {

    @Autowired
    private TweetsService service;

    @PostMapping
    public void newTweet(@RequestBody TweetsDto req) {
        service.newTweet(req);
    }

    @GetMapping
    public List<Tweet> getTweets(@RequestParam int page) {
        return service.getTweets(page);
    }

    @GetMapping("/{username}")
    public List<Tweet> getTweetsFromUser(@PathVariable String username) {
        return service.getTweetsFromUser(username);
    }

}
