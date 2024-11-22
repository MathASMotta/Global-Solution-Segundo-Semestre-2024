package br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.service;

import org.springframework.stereotype.Service;

import br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.repository.RegistroDeProducaoRepository;
import br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.entity.RegistroDeProducao;

@Service
public class RegistroDeProducaoService {
    
    private final RegistroDeProducaoRepository registroDeProducaoRepository;

    public RegistroDeProducaoService(RegistroDeProducaoRepository registroDeProducaoRepository) {
        this.registroDeProducaoRepository = registroDeProducaoRepository;
    }

    // POST
    public RegistroDeProducao criarRegistroProdução(RegistroDeProducao registroDeProducao) {
        return registroDeProducaoRepository.save(registroDeProducao);
    }

}
