package br.com.vinicius.finance_control_api.domain.repository;

import br.com.vinicius.finance_control_api.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
