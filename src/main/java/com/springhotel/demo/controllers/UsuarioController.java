package com.springhotel.demo.controllers;

import com.springhotel.demo.models.Usuario;
import com.springhotel.demo.services.UsuarioService;
// Imports necesarios
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.*;
import java.util.Optional; 
import java.util.List; // Se deja si se usa, aunque estaba marcado como no usado

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    
    @GetMapping
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioService.listarTodas());
        return "lista_usuarios";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "formulario_usuario";
    }

    @PostMapping("/guardar")
    public String guardarUsuario(@ModelAttribute Usuario usuario) {
        // La llamada a registrarNuevoUsuario ahora existe en el Servicio.
        usuarioService.registrarNuevoUsuario(usuario); 
        return "redirect:/usuarios"; 
    }
    
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Integer id, Model model) { // Usa Integer
        Optional<Usuario> usuario = usuarioService.buscarPorId(id);
        usuario.ifPresent(u -> model.addAttribute("usuario", u));
        return "formulario_usuario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Integer id) { // Usa Integer
        usuarioService.eliminar(id);
        return "redirect:/usuarios";
    }
}