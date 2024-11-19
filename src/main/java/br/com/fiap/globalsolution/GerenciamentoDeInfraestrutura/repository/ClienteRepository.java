package br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.repository;

import br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {
    Optional<Cliente> findByDocumento(String documento);
}