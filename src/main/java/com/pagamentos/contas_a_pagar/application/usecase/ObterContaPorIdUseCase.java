package com.pagamentos.contas_a_pagar.application.usecase;

import com.pagamentos.contas_a_pagar.domain.model.ContasPagar;
import com.pagamentos.contas_a_pagar.infrastructure.provider.ContasPagarProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ObterContaPorIdUseCase {

    @Autowired
    private ContasPagarProvider provider;

  public Optional<ContasPagar> findById(UUID id) {
        return Optional.ofNullable(provider.findById(id)
         .orElseThrow(() -> new RuntimeException("Conta não encontrada")));

    }
}
