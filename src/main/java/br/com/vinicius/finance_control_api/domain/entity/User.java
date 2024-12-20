package br.com.vinicius.finance_control_api.domain.entity;

import br.com.vinicius.finance_control_api.controller.request.user.UserRequestDTO;
import br.com.vinicius.finance_control_api.controller.request.user.UserUpdateRequestDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    @Column(unique = true)
    private String email;
    private String password;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Transaction> transactions;

    public User(UserRequestDTO request) {
        this.id = getId();
        this.username = request.username();
        this.email = request.email();
        this.password = request.password();
    }

    public void update(UserUpdateRequestDTO request) {
        if (request.username() != null) {
            this.username = request.username();
        }
        if (request.email() != null) {
            this.email = request.email();
        }
        if (request.password() != null) {
            this.password = request.password();
        }
    }
}
