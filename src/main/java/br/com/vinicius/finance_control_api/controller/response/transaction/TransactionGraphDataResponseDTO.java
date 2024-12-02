package br.com.vinicius.finance_control_api.controller.response.transaction;

import br.com.vinicius.finance_control_api.domain.projection.TransactionGraphData;

public class TransactionGraphDataResponseDTO {

    public String description;
    public Double value;

    public TransactionGraphDataResponseDTO(TransactionGraphData projection) {
        this.description = projection.getDescription();
        this.value = projection.getValue();
    }
}
