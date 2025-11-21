package com.springhotel.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controlador para la URL raíz (página de inicio).
 * 🔹 Argumento Académico: Este controlador solo maneja la navegación básica,
 * manteniendo la responsabilidad única (Single Responsibility Principle - SRP)
 * de enrutar al usuario al menú principal.
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index"; // Muestra la plantilla index.html
    }
}