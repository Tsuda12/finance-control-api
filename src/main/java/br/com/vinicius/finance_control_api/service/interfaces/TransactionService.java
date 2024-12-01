package br.com.vinicius.finance_control_api.service.interfaces;

import br.com.vinicius.finance_control_api.controller.request.transaction.TransactionRequestDTO;

public interface TransactionService {

    void create(Long id, TransactionRequestDTO request);
}
