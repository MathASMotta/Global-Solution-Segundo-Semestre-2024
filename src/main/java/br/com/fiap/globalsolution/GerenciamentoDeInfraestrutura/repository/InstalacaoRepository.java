package br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.entity.Instalacao;

@Repository
public interface InstalacaoRepository extends JpaRepository<Instalacao, String> {
    Optional<Instalacao> findByUuid(String instalacaoUuid);
}
