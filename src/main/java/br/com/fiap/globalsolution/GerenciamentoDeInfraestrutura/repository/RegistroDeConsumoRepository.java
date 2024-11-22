package br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.entity.RegistroDeConsumo;

@Repository
public interface RegistroDeConsumoRepository extends JpaRepository<RegistroDeConsumo, String> {
    Optional<RegistroDeConsumo> findByRegistroConsumoUuid(String registroConsumoUuid);

    @Query("SELECT r FROM RegistroDeConsumo r WHERE r.instalacaoUuid = :instalacaoUuid " +
       "AND MONTH(r.medicaoTimestamp) = :mes AND YEAR(r.medicaoTimestamp) = :ano " +
       "ORDER BY r.medicaoTimestamp")
    List<RegistroDeConsumo> findRegistrosByInstalacaoAndMes(
        @Param("instalacaoUuid") String instalacaoUuid, 
        @Param("mes") int mes, 
        @Param("ano") int ano);
}

