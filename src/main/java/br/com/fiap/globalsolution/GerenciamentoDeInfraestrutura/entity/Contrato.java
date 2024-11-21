package br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class Contrato {

    @Id
    @Column(name = "contratoUuid", updatable = false, nullable = false)
    private String contratoUuid;

    @Column(name = "instalacaoUuid", nullable = false)
    private String instalacaoUuid;

    @Column(name = "clienteUuid", nullable = false)
    private String clienteUuid;

    @Column(name = "timeframe", nullable = false)
    private int timeframe;

    @Column(name = "status", nullable = false)
    private Boolean status;

    @Column(name = "timestamp", nullable = false)
    private LocalDateTime timestamp;

    public Contrato() {
        this.contratoUuid = UUID.randomUUID().toString();
    }

    // Getters e Setters
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
