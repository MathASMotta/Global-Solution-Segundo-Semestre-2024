package br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.entity.RegistroDeProducao;

@Repository
public interface RegistroDeProducaoRepository extends JpaRepository<RegistroDeProducao, String> {
    Optional<RegistroDeProducao> findByRegistroProducaoUuid(String registroProducaoUuid);
}
