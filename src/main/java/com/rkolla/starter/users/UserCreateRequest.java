package com.rkolla.starter.users;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserCreateRequest(
    @NotBlank String name,
    @Email @NotBlank String email
) {}
