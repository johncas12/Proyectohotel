package com.springhotel.demo.controllers;

import com.springhotel.demo.models.Habitacion;
import com.springhotel.demo.repositories.HabitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/habitaciones")
public class HabitacionController {

    @Autowired
    private HabitacionRepository habitacionRepository;

    @GetMapping("/lista")
    public String listarHabitaciones(Model model) {
        model.addAttribute("habitaciones", habitacionRepository.findAll());
        return "lista-habitaciones";
    }

    @GetMapping("/formulario")
    public String mostrarFormulario(Model model) {
        model.addAttribute("habitacion", new Habitacion());
        return "formulario-habitacion";
    }

    @PostMapping("/guardar")
    public String guardarHabitacion(@ModelAttribute Habitacion habitacion) {
        habitacionRepository.save(habitacion);
        return "redirect:/habitaciones/lista";
    }

    @GetMapping("/editar/{id}")
    public String editarHabitacion(@PathVariable Long id, Model model) {
        Habitacion habitacion = habitacionRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("ID inválido"));
        model.addAttribute("habitacion", habitacion);
        return "formulario-habitacion";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarHabitacion(@PathVariable Long id) {
        habitacionRepository.deleteById(id);
        return "redirect:/habitaciones/lista";
    }
}