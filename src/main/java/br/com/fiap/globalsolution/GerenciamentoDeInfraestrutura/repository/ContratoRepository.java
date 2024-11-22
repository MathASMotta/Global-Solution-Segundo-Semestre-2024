package br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.entity.Contrato;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, String> {
    Optional<Contrato> findByContratoUuid(String contratoUuid);
}
