package br.com.vinicius.finance_control_api.service;

import br.com.vinicius.finance_control_api.controller.request.LoginRequestDTO;
import br.com.vinicius.finance_control_api.controller.response.UserResponseDTO;
import br.com.vinicius.finance_control_api.domain.entity.User;
import br.com.vinicius.finance_control_api.domain.repository.UserRepository;
import br.com.vinicius.finance_control_api.service.interfaces.LoginService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    private UserRepository userRepository;

    public LoginServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDTO login(LoginRequestDTO request) {
        User user = userRepository.findByEmailAndPassword(request.email(), request.password());
        if (user == null) {
            throw new EntityNotFoundException();
        }

        return new UserResponseDTO(user.getUsername(), user.getEmail());
    }
}
