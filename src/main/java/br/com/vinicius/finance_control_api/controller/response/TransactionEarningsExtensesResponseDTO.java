package br.com.vinicius.finance_control_api.controller.response;

import br.com.vinicius.finance_control_api.domain.entity.Transaction;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class TransactionEarningsExtensesResponseDTO {

    public Double value;
    public String description;
    @JsonFormat(pattern = "dd/MM/yyyy")
    public LocalDate date;

    public TransactionEarningsExtensesResponseDTO(Transaction entity) {
        this.value = entity.getValue();
        this.description = entity.getDescription();
        this.date = entity.getDate();
    }
}
