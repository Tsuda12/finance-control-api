package br.com.vinicius.finance_control_api.domain.repository;

import br.com.vinicius.finance_control_api.domain.projection.TransactionDataByMonthProjection;
import br.com.vinicius.finance_control_api.domain.projection.TransactionDataProjection;
import br.com.vinicius.finance_control_api.domain.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query(value = """
            SELECT
                SUM(CASE
                    WHEN t.value > 0 then t.value
                    END) as earnings,
            
                SUM(CASE
                    WHEN t.value < 0 then t.value
                    END) as expenses,
            
                SUM(t.value) as balance,
           
                COUNT(t.value) as all_entries
            FROM
                transactions t
            WHERE
                t.user_id = :id
            """, nativeQuery = true)
    TransactionDataProjection getCardData(Long id);
}
