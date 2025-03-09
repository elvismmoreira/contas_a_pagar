package com.pagamentos.contas_a_pagar.infrastructure.provider;

import com.pagamentos.contas_a_pagar.domain.model.ContasPagar;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ContasPagarProvider {


    ContasPagar saveAccounts(ContasPagar contasPagar);

    List<ContasPagar> listAllAccounts();

    Optional<ContasPagar> findById(UUID id);

  }


