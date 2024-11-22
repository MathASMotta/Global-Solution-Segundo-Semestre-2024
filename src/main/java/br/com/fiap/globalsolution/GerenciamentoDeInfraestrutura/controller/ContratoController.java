package br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.controller;

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
import br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.exception.ResourceNotFoundException;
import br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.service.ContratoService;

@RestController
@RequestMapping("/api/contrato")
public class ContratoController {
    
    private final ContratoService contratoService;

    public ContratoController(ContratoService contratoService) {
        this.contratoService = contratoService;
    }


    @PostMapping
    public ResponseEntity<?> criarContrato(@RequestBody ContratoDTO contratoDTO) {
        try {
            Contrato contrato = contratoService.criarContrato(
                contratoDTO.getClienteUuid(),
                contratoDTO.getInstalacaoUuid(),
                contratoDTO.getTimeframe()
            );
            return ResponseEntity.status(HttpStatus.CREATED).body(contrato);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }


    @GetMapping("/{uuid}")
    public ResponseEntity<Contrato> buscarContratoPorId(@PathVariable String uuid) {
        return contratoService.buscarPorUuid(uuid)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> deletarContrato(@PathVariable String uuid) {
        contratoService.deletarContrato(uuid);
        return ResponseEntity.noContent().build();
    }

}
