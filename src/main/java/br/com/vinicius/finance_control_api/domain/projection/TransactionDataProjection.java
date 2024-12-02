package br.com.vinicius.finance_control_api.domain.projection;

public interface TransactionDataProjection {
    Double getEarnings();
    Double getExpenses();
    Double getBalance();
    Integer getAllEntries();
}
