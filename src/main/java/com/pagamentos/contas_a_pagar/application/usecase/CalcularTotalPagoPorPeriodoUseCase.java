package com.pagamentos.contas_a_pagar.application.usecase;

import com.pagamentos.contas_a_pagar.infrastructure.provider.ContasPagarProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class CalcularTotalPagoPorPeriodoUseCase {

    @Autowired
    private ContasPagarProvider provider;

    public BigDecimal calculateTotalPaidInPeriod(LocalDateTime inicio, LocalDateTime fim){
        return provider.calculateTotalPaidInPeriod(inicio, fim)
                .orElse(BigDecimal.ZERO);
    }


}
