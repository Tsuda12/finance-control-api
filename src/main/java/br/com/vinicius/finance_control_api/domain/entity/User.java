package br.com.vinicius.finance_control_api.domain.entity;

import br.com.vinicius.finance_control_api.controller.request.UserRequestDTO;
import jakarta.persistence.*;
import lombok.*;

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
    private String email;
    private String password;

    public User(UserRequestDTO request) {
        this.id = getId();
        this.username = request.username();
        this.email = request.email();
        this.password = request.password();
    }
}
