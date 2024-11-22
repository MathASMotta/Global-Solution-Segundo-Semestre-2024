package br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "CLIENTES")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "CLIENTE_UUID", updatable = false, nullable = false)
    private String clienteUuid;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "ENDERECO", nullable = false)
    private String endereco;

    @Column(name = "DOCUMENTO", nullable = false, unique = true)
    @NotBlank(message = "O documento é obrigatório")
    @Size(min = 11, max = 14, message = "O documento deve ter entre 11 e 14 caracteres")
    private String documento;

    @Column(name = "TIPO", nullable = false)
    private String tipoCliente;

    @Column(name = "CEP", nullable = false)
    private String cep;

    @Column(name = "ATIVO", nullable = false)
    private Boolean ativo;

    public Cliente() {    
    }

    // Getters e Setters
    public String getClienteUuid() {
        return clienteUuid;
    }
    
    public void setClienteUuid(String clienteUuid) {
        this.clienteUuid = clienteUuid;
    }

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
