package br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.entity;

import java.time.LocalDate;
import java.util.UUID;

import org.hibernate.id.uuid.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class Contrato {
    
    @Id
    @Column(name = "contratoUuid", updatable = false, nullable = false)
    private String contratoUuid;

    @Column(name = "cliente", nullable = false)
    private Cliente cliente;

    @Column(name = "instalacao", nullable = false)
    private Instalacao instalacao;

    @Column(name = "dataInicio", nullable = false)
    private LocalDate dataInicio;

    @Column(name = "duracaoDias", nullable = false)
    private int duracaoDias;

    @Column(name = "ativo", nullable = false)
    private Boolean ativo = true;

    // Getters e setters

    public Contrato() {
        this.contratoUuid = UUID.randomUUID().toString();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Instalacao getInstalacao() {
        return instalacao;
    }

    public void setInstalacao(Instalacao instalacao) {
        this.instalacao = instalacao;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public int getDuracaoDias() {
        return duracaoDias;
    }

    public void setDuracaoDias(int duracaoDias) {
        this.duracaoDias = duracaoDias;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

}
