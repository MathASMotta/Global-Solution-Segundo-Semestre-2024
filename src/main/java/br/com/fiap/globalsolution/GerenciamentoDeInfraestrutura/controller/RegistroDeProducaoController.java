package br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.dto.RegistroDeProducaoDTO;
import br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.entity.RegistroDeProducao;
import br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.service.RegistroDeProducaoService;

@RestController
@RequestMapping("/api/producao")
public class RegistroDeProducaoController {
    
    private final RegistroDeProducaoService registroDeProducaoService;

    public RegistroDeProducaoController(RegistroDeProducaoService registroDeProducaoService) {
        this.registroDeProducaoService = registroDeProducaoService;
    }

    @PostMapping
    public ResponseEntity<RegistroDeProducao> criarRegistro(@RequestBody RegistroDeProducaoDTO registroDeProducaoDTO) {
        RegistroDeProducao registro = new RegistroDeProducao();
        registro.setInstalacaoUuid(registroDeProducaoDTO.getInstalacaoUuid());
        registro.setProducaoKWH(registroDeProducaoDTO.getProducaoKWH());
        registro.setMedicaoTimestamp(registroDeProducaoDTO.getMedicaoTimestamp());
        registro.setCreatedAt(LocalDateTime.now());
        return new ResponseEntity<>(registroDeProducaoService.criarRegistroProdução(registro), HttpStatus.CREATED);
    }

}
