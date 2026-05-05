# 📡 Sistema IoT de Iluminação Inteligente com ESP32

## 📖 Descrição do Projeto
Este projeto implementa um sistema de **iluminação inteligente** utilizando um ESP32, um sensor de luminosidade (LDR) e um LED, com comunicação via HTTP com um backend.

O sistema simula um cenário de automação residencial, onde a iluminação pode ser controlada automaticamente com base na luz ambiente ou manualmente por um sistema externo.

---

## 🎯 Objetivo
Desenvolver uma solução IoT capaz de:
- Monitorar a luminosidade do ambiente
- Enviar dados para um servidor remoto
- Receber decisões inteligentes
- Controlar dispositivos físicos (LED)

---

## 🧰 Tecnologias Utilizadas

### 🔌 Hardware
- ESP32 DevKit V4  
- Sensor LDR (fotoresistor)  
- LED  
- Resistor 220Ω  

### 💻 Software
- Arduino IDE  
- WiFi (ESP32)  
- HTTPClient  
- ArduinoJson  
- Wokwi (simulador)  

### 🌐 Backend
- API REST (Cloudflare Tunnel)

---

## ⚙️ Funcionamento do Sistema

### 🔁 Fluxo Geral
1. O ESP32 conecta ao WiFi  
2. Define um threshold inicial (500) no backend  
3. Lê o valor do sensor LDR  
4. Envia os dados para a API  
5. O backend processa a informação  
6. Retorna o estado do LED e o modo  
7. O ESP32 executa a ação no LED  

---

## 🔌 Esquema de Ligação

### 📍 LDR
- VCC → 3.3V  
- GND → GND  
- AO → GPIO 34  

### 📍 LED
- Ânodo → GPIO 26  
- Cátodo → Resistor → GND  

## 🔄 Modos de Operação

### 🟢 Automático
- Baseado no valor do LDR  
- Escuro → LED ligado  
- Claro → LED desligado  

### 🔵 Manual
- Controlado externamente  
- Ignora o sensor  

---

## 🚀 Como Executar

1. Abra o Wokwi  
2. Monte o circuito  
3. Cole o código no ESP32  
4. Execute a simulação  
5. Abra o monitor serial  
6. Ajuste a luminosidade do LDR  

---

## 📊 Exemplo de Saída

- LDR: 700
- HTTP: 200
- Modo: automático
- Led: Apagado

---

## ⚠️ Problemas Comuns

| Problema           | Solução               |
|--------------------|----------------------|
| WiFi não conecta   | Verifique SSID       |
| Erro HTTP          | Verifique URL        |
| LED não funciona   | Revise conexões      |
| JSON inválido      | Verifique backend    |

---

## 📈 Melhorias Futuras

- Interface web  
- Dashboard em tempo real  
- Banco de dados  
- Notificações  
- Suporte a múltiplos dispositivos  

---

## 🧠 Conceitos Aplicados

- IoT (Internet das Coisas)  
- Comunicação HTTP  
- Cliente-servidor  
- Automação  
