package com.projeto.iot.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.iot.service.IluminacaoService;

// @RestController indica que essa classe recebe e responde requisições HTTP.
// @CrossOrigin permite que o Wokwi e o frontend se comuniquem com o backend.

@RestController
@CrossOrigin(origins = "*")
public class IluminacaoController {

    private final IluminacaoService service;

    // O Spring injeta o service automaticamente aqui
    public IluminacaoController(IluminacaoService service) {
        this.service = service;
    }

    // POST /sensor/luminosidade
    // Arduino envia: { "valor": 320 }
    // Backend responde com o estado atual + decisão do LED
    // -----------------------------------------------------------
    @PostMapping("/sensor/luminosidade")
    public ResponseEntity<Map<String, Object>> receberLuminosidade(
            @RequestBody Map<String, Integer> body) {

        int valor = body.getOrDefault("valor", 0);
        return ResponseEntity.ok(service.processarLuminosidade(valor));
    }

    // GET /estado
    // Frontend consulta o estado atual do sistema a cada 2 segundos
    // -----------------------------------------------------------
    @GetMapping("/estado")
    public ResponseEntity<Map<String, Object>> getEstado() {
        return ResponseEntity.ok(service.getEstado());
    }

    // -----------------------------------------------------------
    // POST /modo
    // Frontend envia: { "modo": "manual" } ou { "modo": "automatico" }
    // -----------------------------------------------------------
    @PostMapping("/modo")
    public ResponseEntity<Map<String, Object>> alterarModo(
            @RequestBody Map<String, String> body) {

        String modo = body.getOrDefault("modo", "automatico");
        return ResponseEntity.ok(service.alterarModo(modo));
    }

    // -----------------------------------------------------------
    // POST /led
    // Frontend envia: { "ligado": true } ou { "ligado": false }
    // Só tem efeito real quando o modo for "manual"
    // -----------------------------------------------------------
    @PostMapping("/led")
    public ResponseEntity<Map<String, Object>> controlarLed(
            @RequestBody Map<String, Boolean> body) {

        boolean ligado = body.getOrDefault("ligado", false);
        return ResponseEntity.ok(service.controlarLed(ligado));
    }

    // -----------------------------------------------------------
    // POST /config/limite
    // Frontend envia: { "valor": 600 }
    // Define o limite: abaixo disso = escuro = LED liga
    // -----------------------------------------------------------
    @PostMapping("/config/threshold")
    public ResponseEntity<Map<String, Object>> atualizarThreshold(
            @RequestBody Map<String, Integer> body) {

        int valor = body.getOrDefault("valor", 500);
        return ResponseEntity.ok(service.atualizarThreshold(valor));
    }
}