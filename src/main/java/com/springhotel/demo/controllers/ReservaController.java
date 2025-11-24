package com.springhotel.demo.controllers;

// Imports necesarios
import com.springhotel.demo.models.Reserva;
import com.springhotel.demo.models.Usuario;
import com.springhotel.demo.models.Habitacion;
import com.springhotel.demo.services.ReservaService; 
import com.springhotel.demo.services.UsuarioService; 
import com.springhotel.demo.services.HabitacionService; 

import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.*;
import java.util.Optional; 
import java.util.List;

@Controller
@RequestMapping("/reservas")
public class ReservaController {
    
    private final ReservaService reservaService;
    private final UsuarioService usuarioService;
    private final HabitacionService habitacionService;
    
    public ReservaController(ReservaService reservaService, UsuarioService usuarioService, HabitacionService habitacionService) {
        this.reservaService = reservaService;
        this.usuarioService = usuarioService;
        this.habitacionService = habitacionService;
    }

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("reserva", new Reserva());
        // Envío de datos para los dropdowns de Thymeleaf
        model.addAttribute("usuarios", usuarioService.listarTodas()); 
        model.addAttribute("habitaciones", habitacionService.listarTodas());
        return "formulario_reserva";
    }

    @GetMapping
    public String listarReservas(Model model) {
        model.addAttribute("reservas", reservaService.listarTodas());
        return "lista_reservas"; 
    }
    
    // Se asume que también tienes el método para guardar reservas
    // @PostMapping("/guardar")
    // public String guardarReserva(@ModelAttribute Reserva reserva) {
    //     reservaService.guardar(reserva);
    //     return "redirect:/reservas"; 
    // }
}