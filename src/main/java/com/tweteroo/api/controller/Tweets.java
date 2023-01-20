package com.tweteroo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.TweetsDto;
import com.tweteroo.api.model.Tweet;
import com.tweteroo.api.service.TweetsService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/tweets")
public class Tweets {

    @Autowired
    private TweetsService service;

    @PostMapping
    public void newTweet(@RequestBody TweetsDto req) {
        service.newTweet(req);
    }

    @GetMapping
    public Page<Tweet> getTweets(
            @PageableDefault(page = 0, size = 5, sort = "id", direction = Direction.DESC) Pageable page) {
        return service.getTweets(page);
    }

    @GetMapping("/{username}")
    public List<Tweet> getTweetsFromUser(@PathVariable String username) {
        return service.getTweetsFromUser(username);
    }

}
