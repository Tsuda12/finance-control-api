package br.com.vinicius.finance_control_api.service.interfaces;

import br.com.vinicius.finance_control_api.controller.request.LoginRequestDTO;
import br.com.vinicius.finance_control_api.controller.response.UserResponseDTO;

public interface LoginService {

    UserResponseDTO login(LoginRequestDTO request);
}
