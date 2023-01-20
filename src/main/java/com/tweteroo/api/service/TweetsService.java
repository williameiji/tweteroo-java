package com.tweteroo.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.api.dto.TweetsDto;
import com.tweteroo.api.model.Tweet;
import com.tweteroo.api.model.User;
import com.tweteroo.api.repository.TweetsRepository;
import com.tweteroo.api.repository.UsersRepository;

@Service
public class TweetsService {

    @Autowired
    private TweetsRepository repository;

    @Autowired
    private UsersRepository usersRepository;

    public Tweet newTweet(TweetsDto dto) {
        List<User> user = usersRepository.findByUsername(dto.username());
        return repository.save(new Tweet(dto, user.get(0).getAvatar()));
    }

    public List<Tweet> getTweets(int page) {
        return repository.findAll();
    }

    public List<Tweet> getTweetsFromUser(String username) {
        return repository.findByUsername(username);
    }
}
