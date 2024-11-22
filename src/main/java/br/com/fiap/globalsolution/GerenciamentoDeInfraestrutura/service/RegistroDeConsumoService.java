package br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.entity.RegistroDeConsumo;
import br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.exception.ResourceNotFoundException;
import br.com.fiap.globalsolution.GerenciamentoDeInfraestrutura.repository.RegistroDeConsumoRepository;

@Service
public class RegistroDeConsumoService {
    
    private final RegistroDeConsumoRepository registroDeConsumoRepository;

    public RegistroDeConsumoService(RegistroDeConsumoRepository registroDeConsumoRepository) {
        this.registroDeConsumoRepository = registroDeConsumoRepository;
    }

    // POST
    public RegistroDeConsumo criarRegistro(RegistroDeConsumo registroDeConsumo) {
        return registroDeConsumoRepository.save(registroDeConsumo);
    }

    // GET
    public Map<String, Object> calcularConsumo(String instalacaoUuid) {
        // Obter o mês atual
        var now = LocalDateTime.now();
        int mesAtual = now.getMonthValue();
        int anoAtual = now.getYear();

        // Recuperar registros do mês atual ordenados pelo timestamp
        var registrosDoMes = registroDeConsumoRepository.findRegistrosByInstalacaoAndMes(
            instalacaoUuid, mesAtual, anoAtual);

        if (registrosDoMes.isEmpty()) {
            throw new ResourceNotFoundException("Nenhum registro encontrado para o mês atual.");
        }

        // Obter o primeiro e último registros do mês
        var primeiroRegistro = registrosDoMes.get(0);
        var ultimoRegistro = registrosDoMes.get(registrosDoMes.size() - 1);

        // Calcular consumo mensal e diário
        double consumoMensal = ultimoRegistro.getConsumoKWH() - primeiroRegistro.getConsumoKWH();
        long diasNoMes = java.time.temporal.ChronoUnit.DAYS.between(
            primeiroRegistro.getMedicaoTimestamp().toLocalDate(),
            ultimoRegistro.getMedicaoTimestamp().toLocalDate()) + 1;

        double consumoDiario = consumoMensal / diasNoMes;

        // Calcular estimativa do consumo mensal baseado no dia atual
        int diasRestantesNoMes = now.getMonth().maxLength() - now.getDayOfMonth();
        double consumoEstimado = consumoDiario * now.getMonth().maxLength();

        // Retornar os dados
        Map<String, Object> resultado = new HashMap<>();
        resultado.put("instalacaoUuid", instalacaoUuid);
        resultado.put("timestampCalculo", now);
        resultado.put("diaReferencia", now.getDayOfMonth());
        resultado.put("mesReferencia", now.getMonth());
        resultado.put("anoReferencia", now.getYear());
        resultado.put("diasParaAcabarOMes", diasRestantesNoMes);
        resultado.put("consumoMensalMedioKwh", consumoMensal);
        resultado.put("consumoDiarioMedioKwh", consumoDiario);
        resultado.put("consumoMensalEstimadoKwh", consumoEstimado);

        return resultado;
    }

}
 