package br.com.vinicius.finance_control_api.controller;

import br.com.vinicius.finance_control_api.controller.request.user.UserRequestDTO;
import br.com.vinicius.finance_control_api.controller.request.user.UserUpdateRequestDTO;
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

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update User by id")
    public void update(@PathVariable Long id, @RequestBody @Valid UserUpdateRequestDTO request) {
        userService.update(id, request);
    }
}
