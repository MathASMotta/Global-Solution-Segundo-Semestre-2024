package br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.service;

import org.springframework.stereotype.Service;

import br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.exception.ResourceNotFoundException;
import br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.repository.ContratoRepository;
import br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.entity.Contrato;

@Service
public class ContratoService {
    private final ContratoRepository contratoRepository;

    public ContratoService(ContratoRepository contratoRepository) {
        this.contratoRepository = contratoRepository;
    }

    // POST
    public Contrato criarContrato(Contrato contrato) {
        return contratoRepository.save(contrato);
    }

    //GET
    public Contrato buscarContratoPorId(String contratoUuid) {
        return contratoRepository.findById(contratoUuid)
                .orElseThrow(() -> new ResourceNotFoundException("Contrato não encontrado"));
    }

    // DELETE
    public void deletraContrato(String contratoUuid) {
        Contrato contrato = buscarContratoPorId(contratoUuid);
        contrato.setStatus(false);
        contratoRepository.save(contrato);
    }


}
