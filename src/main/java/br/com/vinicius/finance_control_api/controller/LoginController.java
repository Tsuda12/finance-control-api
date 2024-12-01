package br.com.vinicius.finance_control_api.controller;

import br.com.vinicius.finance_control_api.controller.request.LoginRequestDTO;
import br.com.vinicius.finance_control_api.controller.response.UserResponseDTO;
import br.com.vinicius.finance_control_api.service.interfaces.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "User Login")
    public UserResponseDTO login(@RequestBody LoginRequestDTO request) {
        return loginService.login(request);
    }
}
