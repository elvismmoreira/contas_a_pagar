package com.pagamentos.contas_a_pagar.infrastructure.providerimpl;

import com.pagamentos.contas_a_pagar.domain.model.ContasPagar;
import com.pagamentos.contas_a_pagar.domain.repository.ContasPagarRepository;
import com.pagamentos.contas_a_pagar.infrastructure.provider.ContasPagarProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ContasPagarProviderImpl implements ContasPagarProvider {

    @Autowired
    private ContasPagarRepository repository;

    @Override
    public ContasPagar saveAccounts(ContasPagar contasPagar) {
        return repository.save(contasPagar);
    }

    @Override
    public List<ContasPagar> lisfindByDescriptionAndDueDate(String descricao, LocalDateTime dataVencimento) {
        return repository.findByDescriptionAndDueDate(descricao,dataVencimento);
    }

    @Override
    public Optional<ContasPagar> findById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public Optional<BigDecimal> calculateTotalPaidInPeriod(LocalDateTime inicio, LocalDateTime fim) {
        return repository.calculateTotalPaidInPeriod(inicio,fim);
    }


}
