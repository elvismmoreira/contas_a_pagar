package com.pagamentos.contas_a_pagar.application.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContasPagarDTO {

    @JsonProperty("id")
    private UUID id;

    @JsonProperty("descricao")
    @NotBlank(message = "Description cannot be blank")
    private String descricao;

    @JsonProperty("valor")
    @NotNull(message = "Value cannot be null")
    private BigDecimal valor;

    @JsonProperty("data_vencimento")
    private LocalDateTime data_vencimento;

    @JsonProperty("data_pagamento")
    private LocalDateTime data_pagamento;

    @JsonProperty("situacao")
    @NotBlank(message = "Situation cannot be blank")
    private String situacao;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDateTime getData_vencimento() {
        return data_vencimento;
    }

    public void setData_vencimento(LocalDateTime data_vencimento) {
        this.data_vencimento = data_vencimento;
    }

    public LocalDateTime getData_pagamento() {
        return data_pagamento;
    }

    public void setData_pagamento(LocalDateTime data_pagamento) {
        this.data_pagamento = data_pagamento;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
}
