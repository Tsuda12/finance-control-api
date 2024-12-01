package br.com.vinicius.finance_control_api.domain.repository;

import br.com.vinicius.finance_control_api.domain.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
