package br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CONTRATO")
public class Contrato {

    @Id
    @Column(name = "CONTRATO_UUID", updatable = false, nullable = false)
    private String contratoUuid;

    @Column(name = "INSTALACAO_UUID", nullable = false)
    private String instalacaoUuid;

    @Column(name = "CLIENTE_UUID", nullable = false)
    private String clienteUuid;

    @Column(name = "TIMEFRAME", nullable = false)
    private int timeframe;

    @Column(name = "STATUS", nullable = false)
    private Boolean status;

    @Column(name = "CONTRATO_INICIO_TIMESTAMP", nullable = false)
    private LocalDateTime timestamp;

    public Contrato() {
    }

    // Getters e Setters
    public String getContratoUuid() {
        return contratoUuid;
    }
    
    public void setContratoUuid(String contratoUuid) {
        this.contratoUuid = contratoUuid;
    }

    public String getInstalacaoUuid() {
        return instalacaoUuid;
    }

    public void setInstalacaoUuid(String instalacaoUuid) {
        this.instalacaoUuid = instalacaoUuid;
    }

    public String getClienteUuid() {
        return clienteUuid;
    }

    public void setClienteUuid(String clienteUuid) {
        this.clienteUuid = clienteUuid;
    }

    public int getTimeframe() {
        return timeframe;
    }

    public void setTimeframe(int timeframe) {
        this.timeframe = timeframe;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

}
