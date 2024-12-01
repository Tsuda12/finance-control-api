package br.com.vinicius.finance_control_api.service.interfaces;

import br.com.vinicius.finance_control_api.controller.request.UserRequestDTO;
import br.com.vinicius.finance_control_api.controller.request.UserUpdateRequestDTO;

public interface UserService {

    void create(UserRequestDTO request);

    void update(Long id, UserUpdateRequestDTO request);
}
