package br.com.vinicius.finance_control_api.controller.request.transaction;

import br.com.vinicius.finance_control_api.domain.enums.TypeEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record TransactionRequestDTO(
        @NotNull
        TypeEnum type,
        @NotNull
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate date,
        @NotBlank
        String description,
        @NotNull
        Double value
) {}
