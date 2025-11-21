package com.springhotel.demo.services;

import com.springhotel.demo.models.Usuario;
import com.springhotel.demo.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Servicio encargado de la lógica de negocio de la entidad Usuario.
 * Proporciona métodos para que el ReservaController obtenga la lista de clientes.
 */
@Service
@Transactional
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    // Inyección de Dependencias por Constructor (La mejor práctica)
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    /**
     * Devuelve la lista completa de todos los usuarios.
     */
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    /**
     * Busca y devuelve un Usuario por su ID.
     */
    public Usuario obtenerPorId(Long id) {
        if (id == null) {
            throw new RuntimeException("El ID de usuario no puede ser nulo.");
        }
        
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario con ID " + id + " no encontrado."));
    }
    
    // Aquí se agregarían los métodos 'guardar' y 'eliminar' si fuera necesario
    // gestionar usuarios desde la aplicación.
}