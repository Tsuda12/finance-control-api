package br.com.vinicius.finance_control_api.controller.request.transaction;

import br.com.vinicius.finance_control_api.domain.enums.TypeEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TransactionRequestDTO(
        @NotNull
        TypeEnum type,
        @NotBlank
        String description,
        @NotNull
        Double value
) {}
