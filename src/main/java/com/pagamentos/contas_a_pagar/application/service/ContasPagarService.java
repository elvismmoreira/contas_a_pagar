package com.pagamentos.contas_a_pagar.application.service;

import com.pagamentos.contas_a_pagar.domain.model.ContasPagar;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ContasPagarService {

    ContasPagar saveAccounts(ContasPagar contasPagar);

    List<ContasPagar> lisfindByDescriptionAndDueDate(String descricao,LocalDateTime dataVencimento);

    Optional<ContasPagar> findById(UUID id);

    BigDecimal calculateTotalPaidInPeriod(LocalDateTime inicio, LocalDateTime fim);

    }
