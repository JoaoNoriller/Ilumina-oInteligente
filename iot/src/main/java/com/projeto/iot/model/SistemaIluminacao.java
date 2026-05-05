package com.projeto.iot.model;

// Essa classe representa o estado do sistema de iluminação.
// Como o sistema é único (uma máquina, um LED), sempre usaremos
// apenas um registro no banco com ID = 1.

public class SistemaIluminacao {

    // Modo atual: "automatico" ou "manual"
    private String modo = "automatico";

    // Limite de luminosidade: abaixo disso = escuro = LED liga
    private int threshold = 500;

    // Estado atual do LED: true = ligado, false = apagado
    private boolean ledLigado = false;

    // Último valor lido pelo LDR (0 = escuro total, 1023 = clarão)
    private int luminosidade = 0;

    // Getters e Setters
    public String getModo() { return modo; }
    public void setModo(String modo) { this.modo = modo; }

    public int getThreshold() { return threshold; }
    public void setThreshold(int threshold) { this.threshold = threshold; }

    public boolean isLedLigado() { return ledLigado; }
    public void setLedLigado(boolean ledLigado) { this.ledLigado = ledLigado; }

    public int getLuminosidade() { return luminosidade; }
    public void setLuminosidade(int luminosidade) { this.luminosidade = luminosidade; }
}