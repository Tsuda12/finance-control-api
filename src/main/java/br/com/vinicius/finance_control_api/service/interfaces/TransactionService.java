package br.com.vinicius.finance_control_api.service.interfaces;

import br.com.vinicius.finance_control_api.controller.request.transaction.TransactionRequestDTO;
import br.com.vinicius.finance_control_api.controller.request.transaction.TransactionUpdateRequestDTO;
import br.com.vinicius.finance_control_api.controller.response.transaction.TransactionDataResponseDTO;
import br.com.vinicius.finance_control_api.controller.response.transaction.TransactionEarningsExtensesResponseDTO;
import br.com.vinicius.finance_control_api.controller.response.transaction.TransactionGraphDataResponseDTO;

import java.util.List;

public interface TransactionService {

    TransactionDataResponseDTO getCardData(Long id);

    TransactionDataResponseDTO getCardDataByMonth(Long id, Integer month, Integer year);

    List<TransactionEarningsExtensesResponseDTO> getAllEarnings(Long id);

    List<TransactionEarningsExtensesResponseDTO> getAllExtenses(Long id);

    List<TransactionGraphDataResponseDTO> getGraphData(Long id);

    void create(Long id, TransactionRequestDTO request);

    void update(Long id, TransactionUpdateRequestDTO request);

    void delete(Long id);
}
