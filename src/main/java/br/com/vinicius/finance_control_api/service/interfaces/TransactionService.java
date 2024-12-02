package br.com.vinicius.finance_control_api.service.interfaces;

import br.com.vinicius.finance_control_api.controller.request.transaction.TransactionRequestDTO;
import br.com.vinicius.finance_control_api.controller.response.TransactionDataResponseDTO;
import br.com.vinicius.finance_control_api.controller.response.TransactionEarningsResponseDTO;

import java.util.List;

public interface TransactionService {

    TransactionDataResponseDTO getCardData(Long id);

    TransactionDataResponseDTO getCardDataByMonth(Long id, Integer month, Integer year);

    List<TransactionEarningsResponseDTO> getAllEarnings(Long id);

    void create(Long id, TransactionRequestDTO request);
}
