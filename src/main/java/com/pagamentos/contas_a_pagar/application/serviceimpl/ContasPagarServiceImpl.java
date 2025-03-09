package com.pagamentos.contas_a_pagar.application.serviceimpl;

import com.pagamentos.contas_a_pagar.application.mapper.ContasPagarMapper;
import com.pagamentos.contas_a_pagar.application.service.ContasPagarService;
import com.pagamentos.contas_a_pagar.application.usecase.CadastrarContaUseCase;
import com.pagamentos.contas_a_pagar.application.usecase.ObterContaPorIdUseCase;
import com.pagamentos.contas_a_pagar.domain.model.ContasPagar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private ContasPagarMapper mapper;


    @Override
    public ContasPagar saveAccounts(ContasPagar contasPagar) {
         return cadastrarContaUseCase.saveAccounts(contasPagar);
      }

    @Override
    public List<ContasPagar> listAllAccounts() {
        return List.of();
    }

    @Override
    public Optional<ContasPagar> findById(UUID id) {
        return obterContaPorIdUseCase.findById(id);
    }

}
