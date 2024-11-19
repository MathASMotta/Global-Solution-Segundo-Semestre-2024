package br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @Column(name = "cliente_uuid", updatable = false, nullable = false)
    private String clienteUuid;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "endereco", nullable = false)
    private String endereco;

    @Column(name = "documento", nullable = false, unique = true)
    private String documento;

    @Column(name = "tipo_cliente", nullable = false)
    private String tipoCliente;

    @Column(name = "cep", nullable = false)
    private String cep;

    @Column(name = "ativo", nullable = false)
    private Boolean ativo;

    public Cliente() {
        this.clienteUuid = UUID.randomUUID().toString();
    }

    // Getters e Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter e Setter para endereco
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    // Getter e Setter para documento
    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    // Getter e Setter para tipoCliente
    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    // Getter e Setter para cep
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
