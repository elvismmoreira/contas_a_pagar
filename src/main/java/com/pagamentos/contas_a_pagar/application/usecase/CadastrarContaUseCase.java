package com.pagamentos.contas_a_pagar.application.usecase;

import com.pagamentos.contas_a_pagar.domain.model.ContasPagar;
import com.pagamentos.contas_a_pagar.infrastructure.provider.ContasPagarProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastrarContaUseCase {

    @Autowired
    private ContasPagarProvider provider;

    public ContasPagar saveAccounts(ContasPagar contasPagar) {
           return provider.saveAccounts(contasPagar);

    }

}
