package br.com.vinicius.finance_control_api.controller;

import br.com.vinicius.finance_control_api.controller.request.UserRequestDTO;
import br.com.vinicius.finance_control_api.service.interfaces.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create User")
    public void create(@RequestBody @Valid UserRequestDTO request) {
        userService.create(request);
    }
}
