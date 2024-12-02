package br.com.vinicius.finance_control_api.domain.entity;

import br.com.vinicius.finance_control_api.controller.request.transaction.TransactionRequestDTO;
import br.com.vinicius.finance_control_api.domain.enums.TypeEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "transactions")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    @Enumerated(EnumType.STRING)
    private TypeEnum type;
    private String description;
    private Double value;
    @ManyToOne
    private User user;

    public Transaction(User user, TransactionRequestDTO request) {
        this.id = getId();
        this.date = request.date();
        this.type = request.type();
        this.description = request.description();
        this.value = request.value();
        this.user = user;
    }
}
