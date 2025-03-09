package com.pagamentos.contas_a_pagar.application.service;

import com.pagamentos.contas_a_pagar.domain.model.ContasPagar;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ContasPagarService {

    ContasPagar saveAccounts(ContasPagar contasPagar);

    List<ContasPagar> listAllAccounts();

    Optional<ContasPagar> findById(UUID id);

    }
