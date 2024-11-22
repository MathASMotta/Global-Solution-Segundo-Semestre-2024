package br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.entity.RegistroDeConsumo;

@Repository
public interface RegistroDeConsumoRepository extends JpaRepository<RegistroDeConsumo, String> {
    Optional<RegistroDeConsumo> findByRegistroConsumoUuid(String registroConsumoUuid);
}
