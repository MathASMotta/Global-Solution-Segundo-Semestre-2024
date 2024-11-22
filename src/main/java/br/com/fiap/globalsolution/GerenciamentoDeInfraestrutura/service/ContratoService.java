package br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.service;

import java.util.Optional;
import org.springframework.stereotype.Service;

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
    public Optional<Contrato> buscarPorUuid(String contratoUuid) {
        return contratoRepository.findByContratoUuid(contratoUuid);
    }

    // DELETE
    public void deletarContrato(String contratoUuid) {
        contratoRepository.deleteById(contratoUuid);
    }
}
