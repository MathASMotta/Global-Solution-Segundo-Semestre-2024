package br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

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
    public Optional<Instalacao> buscarPorUuid(String instalacaoUuid) {
        return instalacaoRepository.findByInstalacaoUuid(instalacaoUuid);
    }

    // GET
    public List<Instalacao> listarIntalacoes() {
        return instalacaoRepository.findAll();
    }

    // DELETE
    public void deletarInstalacao(String instalacaoUuid) {
        instalacaoRepository.deleteById(instalacaoUuid);
    }


}
