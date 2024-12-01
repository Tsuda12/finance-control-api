package br.com.vinicius.finance_control_api.controller.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record UserUpdateRequestDTO(
        @NotEmpty
        String username,
        @NotEmpty
        @Email
        String email,
        @NotEmpty
        String password
) {}
