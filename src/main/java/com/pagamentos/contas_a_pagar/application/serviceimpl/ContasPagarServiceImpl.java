package com.pagamentos.contas_a_pagar.application.serviceimpl;

import com.pagamentos.contas_a_pagar.application.service.ContasPagarService;
import com.pagamentos.contas_a_pagar.application.usecase.CadastrarContaUseCase;
import com.pagamentos.contas_a_pagar.application.usecase.CalcularTotalPagoPorPeriodoUseCase;
import com.pagamentos.contas_a_pagar.application.usecase.ListadeContasPagarUseCase;
import com.pagamentos.contas_a_pagar.application.usecase.ObterContaPorIdUseCase;
import com.pagamentos.contas_a_pagar.domain.model.ContasPagar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class ContasPagarServiceImpl implements ContasPagarService {


    @Autowired
    private CadastrarContaUseCase cadastrarContaUseCase;

    @Autowired
    private ObterContaPorIdUseCase obterContaPorIdUseCase;

    @Autowired
    private CalcularTotalPagoPorPeriodoUseCase calcularTotalPagoPorPeriodoUseCase;

    @Autowired
    private ListadeContasPagarUseCase listadeContasPagarUseCase;


    @Override
    public ContasPagar saveAccounts(ContasPagar contasPagar) {
         return cadastrarContaUseCase.saveAccounts(contasPagar);
      }

    @Override
    public List<ContasPagar> lisfindByDescriptionAndDueDate(String descricao, LocalDateTime dataVencimento) {
        return listadeContasPagarUseCase.lisfindByDescriptionAndDueDate(descricao, dataVencimento);

    }

    @Override
    public Optional<ContasPagar> findById(UUID id) {
        return obterContaPorIdUseCase.findById(id);
    }

    @Override
    public BigDecimal calculateTotalPaidInPeriod(LocalDateTime inicio, LocalDateTime fim) {
        return calcularTotalPagoPorPeriodoUseCase.calculateTotalPaidInPeriod(inicio,fim);
    }

}
