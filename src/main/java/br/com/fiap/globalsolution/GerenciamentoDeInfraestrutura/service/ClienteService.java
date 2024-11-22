package br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.service;

import br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.entity.Cliente;
import br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // POST
    public Cliente criarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // GET
    public Optional<Cliente> buscarPorUuid(String clienteUuid) {
        return clienteRepository.findByClienteUuid(clienteUuid);
    }

    // GET
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    // DELETE
    public void deletarCliente(String clienteUuid) {
        clienteRepository.deleteById(clienteUuid);
    }
}