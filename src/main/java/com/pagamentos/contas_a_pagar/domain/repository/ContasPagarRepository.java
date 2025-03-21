package com.pagamentos.contas_a_pagar.domain.repository;

import com.pagamentos.contas_a_pagar.domain.model.ContasPagar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface ContasPagarRepository extends JpaRepository<ContasPagar, UUID> {

    @Query("SELECT c FROM ContasPagar c WHERE (:descricao IS NULL OR c.descricao LIKE %:descricao%) AND (:data_vencimento IS NULL OR c.data_vencimento = :data_vencimento)")
    List<ContasPagar> findByDescriptionAndDueDate(@Param("descricao") String descricao, @Param("dataVencimento") LocalDateTime dataVencimento);

    @Query("SELECT SUM(c.valor) FROM ContasPagar c WHERE c.situacao = 'PAGO' AND c.data_pagamento BETWEEN :inicio AND :fim")
    Optional<BigDecimal> calculateTotalPaidInPeriod(@Param("inicio") LocalDateTime inicio, @Param("fim") LocalDateTime fim);

}
