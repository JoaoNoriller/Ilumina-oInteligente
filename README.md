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

---

## 🌐 Endpoints da API

### 📍 Definir Threshold