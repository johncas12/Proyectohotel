package com.springhotel.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Maneja la ruta raíz (http://localhost:8080/)
    @GetMapping("/")
    public String index() {
        // CORRECCIÓN: Devolver "index" para que busque el archivo index.html.
        return "index"; 
    }
}