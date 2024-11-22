package br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.repository.ClienteRepository;
import br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.repository.ContratoRepository;
import br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.repository.InstalacaoRepository;
import br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.entity.Contrato;
import br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.exception.ResourceNotFoundException;

@Service
public class ContratoService {

    @Autowired
    private ContratoRepository contratoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private InstalacaoRepository instalacaoRepository;

    public ContratoService(ContratoRepository contratoRepository) {
        this.contratoRepository = contratoRepository;
    }

    // POST
    public Contrato criarContrato(String clienteUuid, String instalacaoUuid, int timeframe) {
        try {
            // Validação de campos obrigatórios
            if (clienteUuid == null || clienteUuid.isEmpty()) {
                throw new IllegalArgumentException("O cliente UUID não pode ser nulo ou vazio.");
            }
            if (instalacaoUuid == null || instalacaoUuid.isEmpty()) {
                throw new IllegalArgumentException("A instalação UUID não pode ser nula ou vazia.");
            }
    
            // Verifica existência do cliente
            clienteRepository.findById(clienteUuid)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com UUID: " + clienteUuid));
    
            // Verifica existência da instalação
            instalacaoRepository.findById(instalacaoUuid)
                .orElseThrow(() -> new ResourceNotFoundException("Instalação não encontrada com UUID: " + instalacaoUuid));
    
            // Criação do contrato
            Contrato contrato = new Contrato();
            contrato.setContratoUuid(UUID.randomUUID().toString()); // Gera um UUID único
            contrato.setClienteUuid(clienteUuid);
            contrato.setInstalacaoUuid(instalacaoUuid);
            contrato.setTimeframe(timeframe);
            contrato.setStatus(true); // Define o status como true
            contrato.setTimestamp(LocalDateTime.now());
    
            // Persistência no banco
            return contratoRepository.save(contrato);
        } catch (IllegalArgumentException e) {
            System.err.println("Erro de validação: " + e.getMessage());
            throw e;
        } catch (ResourceNotFoundException e) {
            System.err.println("Erro de recurso: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            System.err.println("Erro inesperado ao criar contrato: " + e.getMessage());
            throw new RuntimeException("Erro inesperado ao criar contrato.", e);
        }
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
