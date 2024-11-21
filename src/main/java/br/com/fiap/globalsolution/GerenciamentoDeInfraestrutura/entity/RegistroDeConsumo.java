package br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "registroDeConsumo")
public class RegistroDeConsumo {

    @Id
    @Column(name = "registroConsumoUuid", updatable = false, nullable = false)
    private String registroConsumoUuid;

    @Column(name = "instalacaoUuid", nullable = false)
    private String instalacaoUuid;
    
    @Column(name = "consumoKWH", nullable = false)
    private double consumoKWH;
    
    @Column(name = "medicaoTimestamp", nullable = false)
    private LocalDateTime medicaoTimestamp;
    
    @Column(name = "createdAt", nullable = false)
    private LocalDateTime createdAt;

    public RegistroDeConsumo() {
        this.registroConsumoUuid = UUID.randomUUID().toString();
    }

    // Getters e Setters
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
