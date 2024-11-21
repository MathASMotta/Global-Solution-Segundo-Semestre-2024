package br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.dto.ContratoDTO;
import br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.entity.Contrato;
import br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.service.ContratoService;

@RestController
@RequestMapping("/api/contrato")
public class ContratoController {
    
    private final ContratoService contratoService;

    public ContratoController(ContratoService contratoService) {
        this.contratoService = contratoService;
    }

    @PostMapping
    public ResponseEntity<Contrato> criarContrato(@RequestBody ContratoDTO contratoDTO) {
        Contrato contrato = new Contrato();
        contrato.setInstalacaoUuid(contratoDTO.getInstalacaoUuid());
        contrato.setClienteUuid(contratoDTO.getClienteUuid());
        contrato.setTimeframe(contratoDTO.getTimeframe());
        contrato.setStatus(true);
        contrato.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(contratoService.criarContrato(contrato), HttpStatus.CREATED);
    }

    @GetMapping("/<contratoUuid>")
    public ResponseEntity<Contrato> buscarContratoPorId(@PathVariable String id) {
        return ResponseEntity.ok(contratoService.buscarContratoPorId(id));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarContrato(@PathVariable String id) {
        contratoService.deletraContrato(id);
        return ResponseEntity.noContent().build();
    }

}
