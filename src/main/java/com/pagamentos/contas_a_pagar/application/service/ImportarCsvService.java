package com.pagamentos.contas_a_pagar.application.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImportarCsvService {

    void importarCSV(MultipartFile file) throws Exception;
}
