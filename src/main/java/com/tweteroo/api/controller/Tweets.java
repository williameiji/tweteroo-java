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
import com.tweteroo.api.model.User;
import com.tweteroo.api.repository.TweetsRepository;
import com.tweteroo.api.repository.UsersRepository;

@RestController
@RequestMapping("/api/tweets")
public class Tweets {

    @Autowired
    private TweetsRepository repository;

    @Autowired
    private UsersRepository usersRepository;

    @PostMapping
    public void newTweet(@RequestBody TweetsDto req) {
        List<User> user = usersRepository.findByUsername(req.username());
        repository.save(new Tweet(req, user.get(0).getAvatar()));
    }

    @GetMapping
    public List<Tweet> getTweets() {
        return repository.findAll();
    }

    @GetMapping("/{username}")
    public List<Tweet> getTweetsFromUser(@PathVariable String username) {
        return repository.findByUsername(username);
    }

}
