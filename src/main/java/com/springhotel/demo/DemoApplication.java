package com.springhotel.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	/**
	 * Sustentación: Método principal (main) de la aplicación.
	 * SpringApplication.run() inicializa el contexto de Spring, escanea los paquetes 
	 * para encontrar componentes (@Controller, @Service, @Repository) y arranca el servidor web embebido (Tomcat).
	 */
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}