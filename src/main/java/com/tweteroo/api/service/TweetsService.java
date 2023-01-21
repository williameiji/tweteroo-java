package com.tweteroo.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tweteroo.api.dto.TweetsDto;
import com.tweteroo.api.exception.NotFoundException;
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

    public Tweet newTweet(TweetsDto dto) throws NotFoundException {
        Optional<User> user = usersRepository.findByUsername(dto.username());

        if (!user.isPresent())
            throw new NotFoundException("Usuário " + dto.username() + " não encontrado.");

        return repository.save(new Tweet(dto, user.get().getAvatar()));
    }

    public Page<Tweet> getTweets(Pageable page) {
        return repository.findAll(page);
    }

    public List<Tweet> getTweetsFromUser(String username) throws NotFoundException {
        Optional<User> user = usersRepository.findByUsername(username);

        if (!user.isPresent())
            throw new NotFoundException("Usuário " + username + " não encontrado.");

        return repository.findByUsername(user.get().getUsername());
    }
}
