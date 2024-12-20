package br.com.vinicius.finance_control_api.controller;

import br.com.vinicius.finance_control_api.controller.request.transaction.TransactionRequestDTO;
import br.com.vinicius.finance_control_api.controller.request.transaction.TransactionUpdateRequestDTO;
import br.com.vinicius.finance_control_api.controller.response.transaction.TransactionDataResponseDTO;
import br.com.vinicius.finance_control_api.controller.response.transaction.TransactionEarningsExtensesResponseDTO;
import br.com.vinicius.finance_control_api.controller.response.transaction.TransactionGraphDataResponseDTO;
import br.com.vinicius.finance_control_api.service.interfaces.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/user/{id}/data/month")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get data Transactions by User to fill cards by month")
    public TransactionDataResponseDTO getCardData(@PathVariable Long id,
                                                  @RequestParam Integer month,
                                                  @RequestParam Integer year) {
        return transactionService.getCardDataByMonth(id, month, year);
    }

    @GetMapping("/user/{id}/earnings")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all earnings")
    public List<TransactionEarningsExtensesResponseDTO> getAllEarnings(@PathVariable Long id) {
        return transactionService.getAllEarnings(id);
    }

    @GetMapping("/user/{id}/extenses")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all extenses")
    public List<TransactionEarningsExtensesResponseDTO> getAllExtenses(@PathVariable Long id) {
        return transactionService.getAllExtenses(id);
    }

    @GetMapping("/user/{id}/graph")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get decription to fill graph")
    public List<TransactionGraphDataResponseDTO> getGraphData(@PathVariable Long id) {
        return transactionService.getGraphData(id);
    }


    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create Transaction")
    public void create(@PathVariable Long id, @RequestBody @Valid TransactionRequestDTO request) {
        transactionService.create(id, request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update Transaction")
    public void update(@PathVariable Long id, @RequestBody @Valid TransactionUpdateRequestDTO request) {
        transactionService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete Transaction")
    public void delete(@PathVariable Long id) {
        transactionService.delete(id);
    }
}
