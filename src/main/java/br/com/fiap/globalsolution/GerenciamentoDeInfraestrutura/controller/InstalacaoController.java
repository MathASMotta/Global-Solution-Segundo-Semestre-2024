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

    @GetMapping("/{uuid}")
    public ResponseEntity<Instalacao> buscarInstalacaoPorId(@PathVariable String uuid) {
        return instalacaoService.buscarPorUuid(uuid)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/lista")
    public ResponseEntity<List<Instalacao>> listarInstalacoes() {
        List<Instalacao> instalacoes = instalacaoService.listarIntalacoes()
                .stream()
                .map(instalacao -> {
                    return instalacao;
                })
                .collect(Collectors.toList());
        return ResponseEntity.ok(instalacoes);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> deletarInstalacao(@PathVariable String uuid) {
        instalacaoService.deletarInstalacao(uuid);
        return ResponseEntity.noContent().build();
    }

}