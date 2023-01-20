package com.tweteroo.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.tweteroo.api.dto.TweetsDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Tweet {

    public Tweet(TweetsDto data, String image) {
        this.username = data.username();
        this.avatar = image;
        this.text = data.tweet();
    }

    @Id
    @JsonProperty(access = Access.WRITE_ONLY)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 30, nullable = false)
    private String username;

    @Column(length = 200, nullable = false)
    private String avatar;

    @Column(length = 100, nullable = false)
    private String text;

}
