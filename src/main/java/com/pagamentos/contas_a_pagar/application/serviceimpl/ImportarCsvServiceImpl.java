package com.pagamentos.contas_a_pagar.application.serviceimpl;

import com.pagamentos.contas_a_pagar.application.service.ImportarCsvService;
import com.pagamentos.contas_a_pagar.domain.model.ContasPagar;
import com.pagamentos.contas_a_pagar.domain.repository.ContasPagarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@Service
public class ImportarCsvServiceImpl implements ImportarCsvService {

    @Autowired
    private ContasPagarRepository repository;

    @Override
    public void importarCSV(MultipartFile file) {
        List<ContasPagar> contasPagar = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            boolean isFirstLine = true; // Pular o cabeçalho

            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // Pula a primeira linha (cabeçalho)
                }

                String[] dados = line.split(","); // Supondo que o CSV seja separado por vírgulas

                // Validação do campo "value"
                if (!dados[1].matches("-?\\d+(\\.\\d+)?")) { // Verifica se é um número válido
                    throw new RuntimeException("Valor inválido na linha: " + line);
                }

                ContasPagar contaPagar = new ContasPagar();
                contaPagar.setDescricao(dados[0]);
                contaPagar.setValor(new BigDecimal(dados[1]));
                contaPagar.setData_pagamento(LocalDateTime.parse(dados[2], DateTimeFormatter.ISO_LOCAL_DATE_TIME));
                contaPagar.setData_vencimento(dados[3].isEmpty() ? null : LocalDateTime.parse(dados[3], DateTimeFormatter.ISO_LOCAL_DATE_TIME));
                contaPagar.setSituacao(dados[4]);

                contasPagar.add(contaPagar);
            }

            // Salva todas as contas a pagar no banco de dados
            repository.saveAll(contasPagar);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao importar o arquivo CSV: " + e.getMessage(), e);
        }
    }
}
