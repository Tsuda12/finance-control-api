package br.com.vinicius.finance_control_api.service;

import br.com.vinicius.finance_control_api.controller.request.transaction.TransactionRequestDTO;
import br.com.vinicius.finance_control_api.controller.response.TransactionDataResponseDTO;
import br.com.vinicius.finance_control_api.domain.projection.TransactionDataByMonthProjection;
import br.com.vinicius.finance_control_api.domain.projection.TransactionDataProjection;
import br.com.vinicius.finance_control_api.domain.entity.Transaction;
import br.com.vinicius.finance_control_api.domain.entity.User;
import br.com.vinicius.finance_control_api.domain.repository.TransactionRepository;
import br.com.vinicius.finance_control_api.domain.repository.UserRepository;
import br.com.vinicius.finance_control_api.service.interfaces.TransactionService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class TransactionServiceImpl implements TransactionService {

    private UserRepository userRepository;
    private TransactionRepository transactionRepository;

    public TransactionServiceImpl(UserRepository userRepository, TransactionRepository transactionRepository) {
        this.userRepository = userRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    @Transactional
    public TransactionDataResponseDTO getCardData(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        TransactionDataProjection projection = transactionRepository.getCardData(user.getId());

        return new TransactionDataResponseDTO(projection);
    }

    @Override
    @Transactional
    public void create(Long id, TransactionRequestDTO request) {
        User user = userRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        Transaction transaction = new Transaction(user, request);
        transactionRepository.save(transaction);
    }
}
