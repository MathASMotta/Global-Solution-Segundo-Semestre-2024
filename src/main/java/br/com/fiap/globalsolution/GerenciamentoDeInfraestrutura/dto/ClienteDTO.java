package br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.dto;

public class ClienteDTO {

    private String nome;
    private String endereco;
    private String documento;
    private String tipoCliente;
    private String cep;

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

}