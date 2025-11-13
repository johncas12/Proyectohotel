package com.springhotel.demo.controllers;

import com.springhotel.demo.models.Reserva;
import com.springhotel.demo.repositories.ReservaRepository;
import com.springhotel.demo.repositories.UsuarioRepository;
import com.springhotel.demo.repositories.HabitacionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private HabitacionRepository habitacionRepository;

    // ✅ Mostrar el formulario de reserva
    @GetMapping("/formulario")
    public String mostrarFormularioReserva(Model model) {
        model.addAttribute("reserva", new Reserva());
        model.addAttribute("usuarios", usuarioRepository.findAll());
        model.addAttribute("habitaciones", habitacionRepository.findAll());
        return "formulario-reserva"; // archivo HTML en /templates
    }

    // ✅ Procesar el formulario
    @PostMapping("/procesar")
    public String procesarReserva(@ModelAttribute Reserva reserva) {
        if (reserva.getUsuario() == null || reserva.getHabitacion() == null) {
            // Evita errores si no se seleccionó usuario o habitación
            return "redirect:/reservas/formulario?error=true";
        }

        reservaRepository.save(reserva);
        return "redirect:/reservas/lista";
    }

    // ✅ Mostrar la lista de reservas
    @GetMapping("/lista")
    public String listarReservas(Model model) {
        List<Reserva> reservas = reservaRepository.findAll();
        model.addAttribute("reservas", reservas);
        return "lista-reservas"; // archivo HTML en /templates
    }

        @GetMapping("/editar/{id}")
        public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
            Reserva reserva = reservaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido"));
            model.addAttribute("reserva", reserva);
            model.addAttribute("usuarios", usuarioRepository.findAll());
            model.addAttribute("habitaciones", habitacionRepository.findAll());
            return "formulario-reserva";
        }

        @PostMapping("/actualizar/{id}")
        public String actualizarReserva(@PathVariable Long id, @ModelAttribute Reserva reservaActualizada) {
            reservaActualizada.setIdReserva(id);
            reservaRepository.save(reservaActualizada);
            return "redirect:/reservas/lista";
        }

        @GetMapping("/eliminar/{id}")
        public String eliminarReserva(@PathVariable Long id) {
            reservaRepository.deleteById(id);
            return "redirect:/reservas/lista";

            
}

}