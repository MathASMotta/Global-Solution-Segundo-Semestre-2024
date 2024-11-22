package br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.dto;

import java.time.LocalDateTime;

public class RegistroDeConsumoDTO {
    
    private String instalacaoUuid;
    private double consumoKWH;
    private LocalDateTime medicaoTimestamp;

    // Getters e Setters
    public String getInstalacaoUuid() {
        return instalacaoUuid;
    }

    public void setInstalacaoUuid(String instalacaoUuid) {
        this.instalacaoUuid = instalacaoUuid;
    }

    public double getConsumoKWH() {
        return consumoKWH;
    }

    public void setConsumoKWH(double consumoKWH) {
        this.consumoKWH = consumoKWH;
    }

    public LocalDateTime getMedicaoTimestamp() {
        return medicaoTimestamp;
    }
    
    public void setMedicaoTimestamp(LocalDateTime medicaoTimestamp) {
        this.medicaoTimestamp = medicaoTimestamp;
    }

}
