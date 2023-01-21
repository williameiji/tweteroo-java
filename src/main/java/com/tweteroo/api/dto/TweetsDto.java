package com.tweteroo.api.dto;

import jakarta.validation.constraints.NotBlank;

public record TweetsDto(@NotBlank String username, @NotBlank String tweet) {

}
