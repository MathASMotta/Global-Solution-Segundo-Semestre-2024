package br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "registroDeProducao")
public class RegistroDeProducao {

    @Id
    @Column(name = "registroProducaoUuid", updatable = false, nullable = false)
    private String registroProducaoUuid;

    @Column(name = "instalacaoUuid", nullable = false)
    private String instalacaoUuid;
    
    @Column(name = "producaoKWH", nullable = false)
    private double producaoKWH;
    
    @Column(name = "medicaoTimestamp", nullable = false)
    private LocalDateTime medicaoTimestamp;
    
    @Column(name = "createdAt", nullable = false)
    private LocalDateTime createdAt;

    public RegistroDeProducao() {
        this.registroProducaoUuid = UUID.randomUUID().toString();
    }

    // Getters e Setters
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
