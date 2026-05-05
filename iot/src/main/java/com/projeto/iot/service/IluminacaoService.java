package com.projeto.iot.service;

import com.projeto.iot.model.SistemaIluminacao;
import org.springframework.stereotype.Service;
import java.util.Map;

// @Service indica ao Spring que essa classe contém a lógica do sistema.
// Ela fica guardada na memória enquanto o servidor estiver rodando.

@Service
public class IluminacaoService {

    // Estado único do sistema guardado em memória (sem banco de dados)
    private final SistemaIluminacao sistema = new SistemaIluminacao();

    // Recebe a luminosidade do Arduino e decide o estado do LED
    // -------------------------------------------------------
    public Map<String, Object> processarLuminosidade(int valorLDR) {
        sistema.setLuminosidade(valorLDR);
        String mensagem;

        if ("automatico".equals(sistema.getModo())) {
            // SE luminosidade < limite → ambiente escuro → LIGA o LED
            // SE luminosidade >= limite → ambiente claro → APAGA o LED
            boolean escuro = valorLDR < sistema.getThreshold();
            sistema.setLedLigado(escuro);
            mensagem = escuro
                ? "Ambiente escuro — LED ligado automaticamente."
                : "Ambiente claro — LED apagado automaticamente.";
        } else {
            // Modo manual: ignora o sensor, mantém o que o usuário definiu
            mensagem = "Modo manual ativo — LED controlado pelo usuário.";
        }

        return buildResposta(mensagem);
    }

    // Retorna o estado atual do sistema (consultado pelo frontend)
    // -------------------------------------------------------
    public Map<String, Object> getEstado() {
        String mensagem = "automatico".equals(sistema.getModo())
            ? "Sistema operando em modo automático."
            : "Sistema operando em modo manual.";
        return buildResposta(mensagem);
    }

    // Alterna o modo: "automatico" ou "manual"
    // -------------------------------------------------------
    public Map<String, Object> alterarModo(String novoModo) {
        sistema.setModo(novoModo);
        return buildResposta("Modo alterado para: " + novoModo + ".");
    }

    // Liga ou apaga o LED manualmente (só faz diferença no modo manual)
    // -------------------------------------------------------
    public Map<String, Object> controlarLed(boolean ligado) {
        sistema.setLedLigado(ligado);
        return buildResposta("LED " + (ligado ? "ligado" : "apagado") + " manualmente.");
    }

    // Atualiza o valor limite de luminosidade
    // -------------------------------------------------------
    public Map<String, Object> atualizarThreshold(int novoThreshold) {
        sistema.setThreshold(novoThreshold);
        return buildResposta("Threshold atualizado para: " + novoThreshold + ".");
    }

    // Monta o objeto de resposta padrão para todos os endpoints
    // -------------------------------------------------------
    private Map<String, Object> buildResposta(String mensagem) {
        return Map.of(
            "modo",         sistema.getModo(),
            "threshold",    sistema.getThreshold(),
            "ledLigado",    sistema.isLedLigado(),
            "luminosidade", sistema.getLuminosidade(),
            "mensagem",     mensagem
        );
    }
}