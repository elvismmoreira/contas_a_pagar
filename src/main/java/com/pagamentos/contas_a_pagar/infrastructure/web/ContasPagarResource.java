package com.pagamentos.contas_a_pagar.infrastructure.web;

import com.pagamentos.contas_a_pagar.application.dtos.ContasPagarDTO;
import com.pagamentos.contas_a_pagar.application.mapper.ContasPagarMapper;
import com.pagamentos.contas_a_pagar.application.service.ContasPagarService;
import com.pagamentos.contas_a_pagar.application.service.ImportarCsvService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/contas-a-pagar")
public class ContasPagarResource {

    @Autowired
    private ContasPagarService service;

    @Autowired
    private ImportarCsvService importarCsvService;

    @Autowired
    private ContasPagarMapper mapper;

    @PostMapping
    public ResponseEntity<Object> teste(@Valid @RequestBody ContasPagarDTO contasPagarResponse) {
        var contasPagar = mapper.toEntity(contasPagarResponse);
        System.out.println("ContasPagar Mapeada: " + contasPagar); // Verifique os valores da entidade
        return ResponseEntity.ok(service.saveAccounts(contasPagar));
    }

    @PostMapping("/importar-csv")
    public String importarCSV(@RequestParam("file") MultipartFile file) {
        try {
            importarCsvService.importarCSV(file);
            return "Arquivo CSV importado com sucesso!";
        } catch (Exception e) {
            return "Erro ao importar o arquivo CSV: " + e.getMessage();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContasPagarDTO> findById (@PathVariable("id") UUID id) {
        return service.findById(id)
                .map(conta -> ResponseEntity.ok(mapper.toDTO(conta)))
                .orElse(ResponseEntity.notFound().build());
    }
}
