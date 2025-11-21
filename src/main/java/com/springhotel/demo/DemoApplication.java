package com.springhotel.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal de arranque de la aplicación Spring Boot.
 * Mantenerla en el paquete raíz "com.springhotel.demo" para que el escaneo de componentes detecte
 * controllers, repositorios y servicios dentro de subpaquetes.
 */
@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
