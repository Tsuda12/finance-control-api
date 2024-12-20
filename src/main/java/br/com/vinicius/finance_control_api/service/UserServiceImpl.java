package br.com.vinicius.finance_control_api.service;

import br.com.vinicius.finance_control_api.controller.request.user.UserRequestDTO;
import br.com.vinicius.finance_control_api.controller.request.user.UserUpdateRequestDTO;
import br.com.vinicius.finance_control_api.domain.entity.User;
import br.com.vinicius.finance_control_api.domain.repository.UserRepository;
import br.com.vinicius.finance_control_api.service.interfaces.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void create(UserRequestDTO request) {
        User user = new User(request);

        userRepository.save(user);
    }

    @Override
    @Transactional
    public void update(Long id, UserUpdateRequestDTO request) {
        User user = userRepository.getReferenceById(id);
        user.update(request);
    }
}
