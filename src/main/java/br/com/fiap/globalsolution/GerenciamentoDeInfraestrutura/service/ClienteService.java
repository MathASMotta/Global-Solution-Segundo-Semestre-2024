package br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.service;

import br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.entity.Cliente;
import br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.exception.ResourceNotFoundException;
import br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente criarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente buscarPorId(String clienteUuid) {
        return clienteRepository.findById(clienteUuid)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public void deletarCliente(String clienteUuid) {
        Cliente cliente = buscarPorId(clienteUuid);
        cliente.setAtivo(false);
        clienteRepository.save(cliente);
    }
}