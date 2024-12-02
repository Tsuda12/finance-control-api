package br.com.vinicius.finance_control_api.controller.request.transaction;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class TransactionUpdateRequestDTO {

    @NotBlank
    public String description;
    @NotNull
    public Double value;
    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    public LocalDate date;
}
