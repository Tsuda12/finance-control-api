package br.com.vinicius.finance_control_api.domain.repository;

import br.com.vinicius.finance_control_api.domain.entity.Transaction;
import br.com.vinicius.finance_control_api.domain.projection.TransactionDataProjection;
import br.com.vinicius.finance_control_api.domain.projection.TransactionGraphData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

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
                t.user_id = :id AND
                EXTRACT (MONTH FROM t.date) = :month AND
                EXTRACT (YEAR FROM t.date) = :year
            """, nativeQuery = true)
    TransactionDataProjection getCardDataByMonth(Long id, Integer month, Integer year);

    @Query(value = """
            SELECT 
                t.description, count(t.description) as value
            FROM 
                transactions t
            WHERE 
                t.user_id = :id
            GROUP BY
                t.description
            """, nativeQuery = true)
    List<TransactionGraphData> getGraphData(Long id);

    List<Transaction> findAllByUserIdAndValueGreaterThan(Long userId, Double value);

    List<Transaction> findAllByUserIdAndValueLessThan(Long userId, Double value);
}
