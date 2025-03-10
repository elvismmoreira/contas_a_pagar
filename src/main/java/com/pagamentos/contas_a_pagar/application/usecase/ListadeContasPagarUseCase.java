package com.pagamentos.contas_a_pagar.application.usecase;

import com.pagamentos.contas_a_pagar.domain.model.ContasPagar;
import com.pagamentos.contas_a_pagar.infrastructure.provider.ContasPagarProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ListadeContasPagarUseCase {

    @Autowired
    private ContasPagarProvider provider;

    public List<ContasPagar> lisfindByDescriptionAndDueDate(String descricao, LocalDateTime dataVencimento){
        return provider.lisfindByDescriptionAndDueDate(descricao, dataVencimento);
    }
}
