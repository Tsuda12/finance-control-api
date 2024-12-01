package br.com.vinicius.finance_control_api.service.interfaces;

import br.com.vinicius.finance_control_api.controller.request.UserRequestDTO;

public interface UserService {

    void create(UserRequestDTO request);
}
