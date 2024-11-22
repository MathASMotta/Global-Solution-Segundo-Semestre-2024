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

    @GetMapping("/{uuid}")
    public ResponseEntity<Cliente> buscarClientePorUuid(@PathVariable String uuid) {
        return clienteService.buscarPorUuid(uuid)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/lista")
    public ResponseEntity<List<Cliente>> listarClientes() {
        List<Cliente> clientes = clienteService.listarClientes()
                .stream()
                .map(cliente -> {
                    return cliente;
                })
                .collect(Collectors.toList());
        return ResponseEntity.ok(clientes);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> deletarCliente(@PathVariable String uuid) {
        clienteService.deletarCliente(uuid);
        return ResponseEntity.noContent().build();
    }
}