package com.springhotel.demo.controllers;

// Imports necesarios
import com.springhotel.demo.models.Habitacion;
import com.springhotel.demo.services.HabitacionService; 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*; 
import org.springframework.ui.Model; 
import java.util.Optional; 
import java.util.List;

@Controller
@RequestMapping("/habitaciones")
public class HabitacionesController {

    private final HabitacionService habitacionService;

    public HabitacionesController(HabitacionService habitacionService) {
        this.habitacionService = habitacionService;
    }

    @GetMapping
    public String listarHabitaciones(Model model) {
        model.addAttribute("habitaciones", habitacionService.listarTodas());
        model.addAttribute("habitacion", new Habitacion());
        return "lista_habitaciones";
    }

    @PostMapping("/guardar")
    public String guardarHabitacion(@ModelAttribute Habitacion habitacion) {
        habitacionService.guardar(habitacion);
        return "redirect:/habitaciones";
    }
    
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Integer id, Model model) { // Usa Integer
        // CORRECCIÓN: Usar 'buscarPorId' (resolviendo error 'obtenerPorId')
        Optional<Habitacion> habitacion = habitacionService.buscarPorId(id); 
        habitacion.ifPresent(h -> model.addAttribute("habitacion", h));
        return "formulario_habitacion";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarHabitacion(@PathVariable Integer id) { // Usa Integer
        habitacionService.eliminar(id);
        return "redirect:/habitaciones";
    }
}