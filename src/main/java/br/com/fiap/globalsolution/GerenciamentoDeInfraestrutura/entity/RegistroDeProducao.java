package br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "REGISTRO_PRODUCAO")
public class RegistroDeProducao {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "REGISTRO_PRODUCAO_UUID", updatable = false, nullable = false)
    private String registroProducaoUuid;

    @Column(name = "INSTALACAO_UUID", nullable = false)
    private String instalacaoUuid;
    
    @Column(name = "PRODUCAO_KWH", nullable = false)
    private double producaoKWH;
    
    @Column(name = "MEDICAO_TIMESTAMP", nullable = false)
    private LocalDateTime medicaoTimestamp;
    
    @Column(name = "CREATED_AT", nullable = false)
    private LocalDateTime createdAt;

    public RegistroDeProducao() {
    }

    // Getters e Setters
    public String getRegistroProducaoUuid() {
        return registroProducaoUuid;
    }

    public void setRegistroProducaoUuid(String registroProducaoUuid) {
        this.registroProducaoUuid = registroProducaoUuid;
    }

    public String getInstalacaoUuid() {
        return instalacaoUuid;
    }

    public void setInstalacaoUuid(String instalacaoUuid) {
        this.instalacaoUuid = instalacaoUuid;
    }

    public double getProducaoKWH() {
        return producaoKWH;
    }

    public void setProducaoKWH(double producaoKWH) {
        this.producaoKWH = producaoKWH;
    }

    public LocalDateTime getMedicaoTimestamp() {
        return medicaoTimestamp;
    }
    
    public void setMedicaoTimestamp(LocalDateTime medicaoTimestamp) {
        this.medicaoTimestamp = medicaoTimestamp;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
