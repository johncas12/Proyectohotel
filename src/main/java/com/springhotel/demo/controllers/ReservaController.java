package com.springhotel.demo.controllers;


import com.springhotel.demo.models.Reserva;
import com.springhotel.demo.services.HabitacionService;
import com.springhotel.demo.services.ReservaService;
import com.springhotel.demo.services.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Controlador principal para todas las operaciones relacionadas con Reservas.
 * Mapea la ruta base /reservas.
 */
@Controller
@RequestMapping("/reservas")
public class ReservaController {

    private final ReservaService reservaService;
    private final UsuarioService usuarioService;
    private final HabitacionService habitacionService;

    /**
     * Inyección de Dependencias por Constructor.
     * 🔹 Argumento Académico: Esta es la forma preferida en Spring 3+
     * porque garantiza que el objeto Controller no se inicialice sin sus
     * dependencias esenciales (los Services), haciendo el código más robusto.
     */
    public ReservaController(ReservaService reservaService, UsuarioService usuarioService, HabitacionService habitacionService) {
        this.reservaService = reservaService;
        this.usuarioService = usuarioService;
        this.habitacionService = habitacionService;
    }

    // --- C.R.U.D. - READ (Listar todas las reservas) ---
    @GetMapping("/lista")
    public String listarReservas(Model model) {
        model.addAttribute("reservas", reservaService.listarTodas());
        return "lista_reservas"; // Muestra lista_reservas.html
    }

    // --- C.R.U.D. - CREATE & UPDATE (Mostrar formularios) ---
    
    // Mapea /reservas/nuevo (para crear) y /reservas/editar/{id} (para editar)
    @GetMapping({"/nuevo", "/editar/{id}"})
    public String mostrarFormulario(@PathVariable(required = false) Long id, Model model) {
        // Si el ID existe, carga la reserva para editar; si no, crea una nueva.
        Reserva reserva = (id == null) ? new Reserva() : reservaService.obtenerPorId(id);
        
        // Carga las colecciones para llenar los menús desplegables (selects) en Thymeleaf.
        model.addAttribute("usuarios", usuarioService.listarTodos());
        model.addAttribute("habitaciones", habitacionService.listarTodas());
        model.addAttribute("reserva", reserva);
        
        // 🔹 Argumento Académico: Se utilizan los servicios de Habitacion y Usuario
        // para poblar el Model, manteniendo la capa Controller delegada
        // de la lógica de negocio a la capa Service.
        
        return "formulario_reserva"; // Muestra formulario_reserva.html
    }
    
    // --- C.R.U.D. - CREATE & UPDATE (Procesar guardado) ---
    @PostMapping("/procesar")
    public String procesarReserva(@ModelAttribute("reserva") Reserva reserva, RedirectAttributes redirectAttributes) {
        try {
            // Delega la validación y el guardado al Servicio.
            reservaService.guardar(reserva);
            
            redirectAttributes.addFlashAttribute("mensaje", "Reserva guardada con éxito.");
            
            // 🔹 Argumento Académico: Uso del patrón PRG (Post-Redirect-Get).
            // Después de un POST exitoso, redirigimos a una petición GET (/reservas/lista),
            // lo que previene que el usuario reenvíe accidentalmente el formulario.
            return "redirect:/reservas/lista"; 
        
        } catch (RuntimeException e) {
            // Manejo básico de errores de validación del servicio.
            redirectAttributes.addFlashAttribute("errorMessage", "Error al guardar la reserva: " + e.getMessage());
            
            // Redirigimos al formulario para que el usuario pueda corregir los datos.
            return "redirect:/reservas/nuevo"; 
        }
    }

    // --- C.R.U.D. - DELETE (Eliminar) ---
    @GetMapping("/eliminar/{id}")
    public String eliminarReserva(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            reservaService.eliminar(id);
            redirectAttributes.addFlashAttribute("mensaje", "Reserva eliminada correctamente.");
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error al eliminar la reserva.");
        }
        return "redirect:/reservas/lista";
    }
}