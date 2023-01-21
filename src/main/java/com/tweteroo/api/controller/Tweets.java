package com.tweteroo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.TweetsDto;
import com.tweteroo.api.exception.InvalidException;
import com.tweteroo.api.exception.CreatedException;
import com.tweteroo.api.exception.NotFoundException;
import com.tweteroo.api.model.Tweet;
import com.tweteroo.api.service.TweetsService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/tweets")
public class Tweets {

    @Autowired
    private TweetsService service;

    @PostMapping
    public ResponseEntity<Tweet> newTweet(@RequestBody TweetsDto req)
            throws NotFoundException, CreatedException, InvalidException {
        var tweet = service.newTweet(req);

        if (tweet != null) {
            throw new CreatedException("Tweet criado!");
        } else {
            throw new InvalidException("Erro ao criar tweet!");
        }
    }

    @GetMapping
    public ResponseEntity<Page<Tweet>> getTweets(
            @PageableDefault(page = 0, size = 5, sort = "id", direction = Direction.DESC) Pageable page) {

        return new ResponseEntity<>(service.getTweets(page), HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<List<Tweet>> getTweetsFromUser(@PathVariable String username)
            throws NotFoundException {
        var tweets = service.getTweetsFromUser(username);

        if (tweets.isEmpty()) {
            throw new NotFoundException("Usuário não tem tweets ainda!");
        } else {
            return new ResponseEntity<>(tweets, HttpStatus.OK);
        }
    }

}
