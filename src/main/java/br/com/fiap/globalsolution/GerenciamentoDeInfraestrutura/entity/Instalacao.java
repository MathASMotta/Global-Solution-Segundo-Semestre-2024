package br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "INSTALACAO")
public class Instalacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "INSTALACAO_UUID", updatable = false, nullable = false)
    private String instalacaoUuid;

    @Column(name = "ENDERECO", nullable = false)
    private String endereco;

    @Column(name = "CEP", nullable = false)
    private String cep;

    @Column(name = "ATIVO", nullable = false)
    private Boolean ativo;

    public Instalacao() {
    }

    // Getters e Setters
    public String getInstalacaoUuid() {
        return instalacaoUuid;
    }
    
    public void setInstalacaoUuid(String instalacaoUuid) {
        this.instalacaoUuid = instalacaoUuid;
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

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

}