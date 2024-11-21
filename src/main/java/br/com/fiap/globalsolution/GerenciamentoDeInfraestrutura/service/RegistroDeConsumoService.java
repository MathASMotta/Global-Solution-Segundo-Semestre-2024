package br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.service;

import org.springframework.stereotype.Service;

import br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.entity.RegistroDeConsumo;
import br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.exception.ResourceNotFoundException;
import br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.repository.RegistroDeConsumoRepository;

@Service
public class RegistroDeConsumoService {
    
    private final RegistroDeConsumoRepository registroDeConsumoRepository;

    public RegistroDeConsumoService(RegistroDeConsumoRepository registroDeConsumoRepository) {
        this.registroDeConsumoRepository = registroDeConsumoRepository;
    }

    // POST
    public RegistroDeConsumo criarRegistro(RegistroDeConsumo registroDeConsumo) {
        return registroDeConsumoRepository.save(registroDeConsumo);
    }

    // GET
    public RegistroDeConsumo buscarRegistroPorId(String registroDeConsumoUuid) {
        return registroDeConsumoRepository.findById(registroDeConsumoUuid)
                .orElseThrow(() -> new ResourceNotFoundException("Registro não encontrado"));
    }

}
 