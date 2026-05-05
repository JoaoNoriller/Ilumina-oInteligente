package com.projeto.iot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IotApplication {

	public static void main(String[] args) {
		SpringApplication.run(IotApplication.class, args);
		System.out.println("Sistema iniciado!!");
		System.out.println("Acesse: http://localhost:8080");
	}
}
 