package br.com.vinicius.finance_control_api.controller.response.transaction;

import br.com.vinicius.finance_control_api.domain.projection.TransactionDataProjection;

public class TransactionDataResponseDTO {

    public Double earnings;
    public Double extenses;
    public Double balance;
    public Integer allEntries;

    public TransactionDataResponseDTO(TransactionDataProjection projection) {
        this.earnings = projection.getEarnings();
        this.extenses = projection.getExpenses();
        this.balance = projection.getBalance();
        this.allEntries = projection.getAllEntries();
    }
}
