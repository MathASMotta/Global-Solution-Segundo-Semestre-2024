package br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.controller;

import br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.dto.ClienteDTO;
import br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.entity.Cliente;
import br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<Cliente> criarCliente(@RequestBody ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setNome(clienteDTO.getNome());
        cliente.setEndereco(clienteDTO.getEndereco());
        cliente.setDocumento(clienteDTO.getDocumento());
        cliente.setTipoCliente(clienteDTO.getTipoCliente());
        cliente.setCep(clienteDTO.getCep());
        cliente.setAtivo(true);
        return new ResponseEntity<>(clienteService.criarCliente(cliente), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable String id) {
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listarClientes() {
        List<ClienteDTO> clientes = clienteService.listarClientes()
                .stream()
                .map(cliente -> {
                    ClienteDTO dto = new ClienteDTO();
                    dto.setNome(cliente.getNome());
                    dto.setEndereco(cliente.getEndereco());
                    dto.setDocumento(cliente.getDocumento());
                    dto.setTipoCliente(cliente.getTipoCliente());
                    dto.setCep(cliente.getCep());
                    return dto;
                })
                .collect(Collectors.toList());
        return ResponseEntity.ok(clientes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable String id) {
        clienteService.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }
}