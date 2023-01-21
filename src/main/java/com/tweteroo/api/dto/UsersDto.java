package com.tweteroo.api.dto;

import jakarta.validation.constraints.NotBlank;

public record UsersDto(@NotBlank String username, @NotBlank String avatar) {

}
