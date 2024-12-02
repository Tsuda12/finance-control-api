package br.com.vinicius.finance_control_api.service.interfaces;

import br.com.vinicius.finance_control_api.controller.request.transaction.TransactionRequestDTO;
import br.com.vinicius.finance_control_api.controller.response.TransactionDataResponseDTO;

public interface TransactionService {

    TransactionDataResponseDTO getCardData(Long id);

    void create(Long id, TransactionRequestDTO request);
}
