package br.com.vinicius.finance_control_api.controller;

import br.com.vinicius.finance_control_api.controller.request.transaction.TransactionRequestDTO;
import br.com.vinicius.finance_control_api.controller.response.TransactionDataResponseDTO;
import br.com.vinicius.finance_control_api.service.interfaces.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/user/{id}/data")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get data Transactions by User to fill cards")
    public TransactionDataResponseDTO getCardData(@PathVariable Long id) {
        return transactionService.getCardData(id);
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create Transaction")
    public void create(@PathVariable Long id, @RequestBody @Valid TransactionRequestDTO request) {
        transactionService.create(id, request);
    }
}
