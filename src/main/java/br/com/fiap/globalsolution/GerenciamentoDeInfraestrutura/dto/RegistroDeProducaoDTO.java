package br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.dto;

import java.time.LocalDateTime;

public class RegistroDeProducaoDTO {
    
    private String instalacaoUuid;
    private double producaoKWH;
    private LocalDateTime medicaoTimestamp;

    // Getters e Setters
    public String getInstalacaoUuid() {
        return instalacaoUuid;
    }

    public void setInstalacaoUuid(String instalacaoUuid) {
        this.instalacaoUuid = instalacaoUuid;
    }

    public double getProducaoKWH() {
        return producaoKWH;
    }

    public void setProducaoKWH(double producaoKWH) {
        this.producaoKWH = producaoKWH;
    }

    public LocalDateTime getMedicaoTimestamp() {
        return medicaoTimestamp;
    }
    
    public void setMedicaoTimestamp(LocalDateTime medicaoTimestamp) {
        this.medicaoTimestamp = medicaoTimestamp;
    }
}
