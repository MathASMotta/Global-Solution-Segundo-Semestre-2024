package br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.dto;

public class ContratoDTO {
    
    private String instalacaoUuid;
    private String clienteUuid;
    private int timeframe;

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

}
