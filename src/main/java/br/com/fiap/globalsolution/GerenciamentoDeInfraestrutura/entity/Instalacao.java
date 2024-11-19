package br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class Instalacao {
    
    @Id
    @Column(name = "instalacaoUuid", updatable = false, nullable = false)
    private String instalacaoUuid;

    @Column(name = "endereco", nullable = false)
    private String endereco;

    @Column(name = "cep", nullable = false)
    private String cep;

    @Column(name = "ativo", nullable = false)
    private boolean ativo = true;

    // Getters e setters

    public Instalacao() {
        this.instalacaoUuid = UUID.randomUUID().toString();
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCpe(String cep) {
        this.cep = cep;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

}
