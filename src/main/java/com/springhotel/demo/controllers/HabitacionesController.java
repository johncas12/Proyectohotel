package com.springhotel.demo.controllers;

import com.springhotel.demo.models.Habitacion;
import com.springhotel.demo.services.HabitacionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/habitaciones")
public class HabitacionesController {

    private final HabitacionService habitacionService;

    // Inyección de Dependencia por Constructor
    public HabitacionesController(HabitacionService habitacionService) {
        this.habitacionService = habitacionService;
    }

    // Muestra el listado de todas las habitaciones (útil para el administrador)
    @GetMapping("/lista")
    public String listarHabitaciones(Model model) {
        model.addAttribute("habitaciones", habitacionService.listarTodas());
        return "lista_habitaciones_admin"; // Necesitarás crear este archivo Thymeleaf
    }

    // Muestra el formulario para crear/editar una habitación
    @GetMapping({"/nuevo", "/editar/{id}"})
    public String mostrarFormulario(@PathVariable(required = false) Long id, Model model) {
        Habitacion habitacion = (id == null) ? new Habitacion() : habitacionService.obtenerPorId(id);
        model.addAttribute("habitacion", habitacion);
        return "formulario_habitacion"; // Necesitarás crear este archivo Thymeleaf
    }

    // Procesa el guardado o actualización de la habitación
    @PostMapping("/guardar")
    public String guardarHabitacion(@ModelAttribute("habitacion") Habitacion habitacion, RedirectAttributes redirectAttributes) {
        try {
            habitacionService.guardar(habitacion);
            redirectAttributes.addFlashAttribute("mensaje", "Habitación guardada con éxito.");
            return "redirect:/habitaciones/lista";
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error al guardar: " + e.getMessage());
            return "redirect:/habitaciones/nuevo";
        }
    }

    // Elimina una habitación
    @GetMapping("/eliminar/{id}")
    public String eliminarHabitacion(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            habitacionService.eliminar(id);
            redirectAttributes.addFlashAttribute("mensaje", "Habitación eliminada.");
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error al eliminar: " + e.getMessage());
        }
        return "redirect:/habitaciones/lista";
    }
}