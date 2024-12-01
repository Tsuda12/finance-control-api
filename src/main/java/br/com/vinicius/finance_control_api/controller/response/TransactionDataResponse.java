package br.com.vinicius.finance_control_api.controller.response;

public interface TransactionDataResponse {
    Double getEarnings();
    Double getExpenses();
    Double getBalance();
}
