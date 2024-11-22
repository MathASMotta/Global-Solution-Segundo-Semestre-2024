package br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.dto.RegistroDeConsumoDTO;
import br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.entity.RegistroDeConsumo;
import br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.service.RegistroDeConsumoService;

@RestController
@RequestMapping("/api/consumo")
public class RegistroDeConsumoController {

    private final RegistroDeConsumoService registroDeConsumoService;

    public RegistroDeConsumoController(RegistroDeConsumoService registroDeConsumoService) {
        this.registroDeConsumoService = registroDeConsumoService;
    }

    @PostMapping
    public ResponseEntity<RegistroDeConsumo> criarRegistro(@RequestBody RegistroDeConsumoDTO registroDeConsumoDTO) {
        RegistroDeConsumo registro = new RegistroDeConsumo();
        registro.setInstalacaoUuid(registroDeConsumoDTO.getInstalacaoUuid());
        registro.setConsumoKWH(registroDeConsumoDTO.getConsumoKWH());
        registro.setMedicaoTimestamp(registroDeConsumoDTO.getMedicaoTimestamp());
        registro.setCreatedAt(LocalDateTime.now());
        return new ResponseEntity<>(registroDeConsumoService.criarRegistro(registro), HttpStatus.CREATED);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<?> calcularConsumo(@PathVariable String uuid) {
        try {
            var resultado = registroDeConsumoService.calcularConsumo(uuid);
            return ResponseEntity.ok(resultado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
