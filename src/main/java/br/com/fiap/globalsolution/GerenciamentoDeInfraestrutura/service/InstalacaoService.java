package br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.exception.ResourceNotFoundException;
import br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.repository.InstalacaoRepository;
import br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.entity.Instalacao;

@Service
public class InstalacaoService {
    
    private final InstalacaoRepository instalacaoRepository;

    public InstalacaoService(InstalacaoRepository instalacaoRepository) {
        this.instalacaoRepository = instalacaoRepository;
    }

    // POST
    public Instalacao criarInstalacao(Instalacao instalacao) {
        return instalacaoRepository.save(instalacao);
    }

    // GET
    public Instalacao buscarInstalacaoPorId(String instalacaoUuid) {
        return instalacaoRepository.findById(instalacaoUuid)
                .orElseThrow(() -> new ResourceNotFoundException("Instalação não encontrada"));
    }

    // GET
    public List<Instalacao> listarIntalacoes() {
        return instalacaoRepository.findAll();
    }

    // DELETE
    public void deletarInstalacao(String instalacaoUuid) {
        Instalacao instalacao = buscarInstalacaoPorId(instalacaoUuid);
        instalacao.setAtivo(false);
        instalacaoRepository.save(instalacao);
    }


}
