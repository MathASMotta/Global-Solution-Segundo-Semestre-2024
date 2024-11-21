package br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.controller;

import br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.dto.InstalacaoDTO;
import br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.entity.Instalacao;
import br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.service.InstalacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/instalacoes")
public class InstalacaoController {

    private final InstalacaoService instalacaoService;

    public InstalacaoController(InstalacaoService instalacaoService) {
        this.instalacaoService = instalacaoService;
    }

    @PostMapping
    public ResponseEntity<Instalacao> criarInstalacao(@RequestBody InstalacaoDTO instalacaoDTO) {
        Instalacao instalacao = new Instalacao();
        instalacao.setEndereco(instalacaoDTO.getEndereco());
        instalacao.setCep(instalacaoDTO.getCep());
        instalacao.setAtivo(true);
        return new ResponseEntity<>(instalacaoService.criarInstalacao(instalacao), HttpStatus.CREATED);
    }

    @GetMapping("/<instalacaoUuid>")
    public ResponseEntity<Instalacao> buscarInstalacaoPorId(@PathVariable String id) {
        return ResponseEntity.ok(instalacaoService.buscarInstalacaoPorId(id));
    }

    @GetMapping("/lista")
    public ResponseEntity<List<InstalacaoDTO>> listarInstalacoes() {
        List<InstalacaoDTO> instalacoes = instalacaoService.listarIntalacoes()
                .stream()
                .map(instalacao -> {
                    InstalacaoDTO dto = new InstalacaoDTO();
                    dto.setEndereco(instalacao.getEndereco());
                    dto.setCep(instalacao.getCep());
                    return dto;
                })
                .collect(Collectors.toList());
        return ResponseEntity.ok(instalacoes);
    }

    @DeleteMapping("/<instalacao_uuid>")
    public ResponseEntity<Void> deletarInstalacao(@PathVariable String id) {
        instalacaoService.deletarInstalacao(id);
        return ResponseEntity.noContent().build();
    }

}