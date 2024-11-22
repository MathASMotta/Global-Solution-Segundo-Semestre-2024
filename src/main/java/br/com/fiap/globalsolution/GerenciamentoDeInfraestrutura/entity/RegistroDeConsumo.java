package br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "REGISTRO_CONSUMO")
public class RegistroDeConsumo {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "REGISTRO_CONSUMO_UUID", updatable = false, nullable = false)
    private String registroConsumoUuid;

    @Column(name = "INSTALACAO_UUID", nullable = false)
    private String instalacaoUuid;
    
    @Column(name = "CONSUMO_KWH", nullable = false)
    private double consumoKWH;
    
    @Column(name = "MEDICAO_TIMESTAMP", nullable = false)
    private LocalDateTime medicaoTimestamp;
    
    @Column(name = "CREATED_AT", nullable = false)
    private LocalDateTime createdAt;

    public RegistroDeConsumo() {
    }

    // Getters e Setters
    public String getRegistroConsumoUuid() {
        return registroConsumoUuid;
    }
    
    public void setRegistroConsumoUuid(String registroConsumoUuid) {
        this.registroConsumoUuid = registroConsumoUuid;
    }
    
    public String getInstalacaoUuid() {
        return instalacaoUuid;
    }

    public void setInstalacaoUuid(String instalacaoUuid) {
        this.instalacaoUuid = instalacaoUuid;
    }

    public double getConsumoKWH() {
        return consumoKWH;
    }

    public void setConsumoKWH(double consumoKWH) {
        this.consumoKWH = consumoKWH;
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
