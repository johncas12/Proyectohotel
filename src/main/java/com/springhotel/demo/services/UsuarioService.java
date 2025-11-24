package com.springhotel.demo.services;

import com.springhotel.demo.models.Usuario;
import com.springhotel.demo.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // MÉTODO AGREGADO: 'registrarNuevoUsuario' (Resuelve el error crítico)
    public Usuario registrarNuevoUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    
    public List<Usuario> listarTodas() {
        return usuarioRepository.findAll();
    }
    
    public Optional<Usuario> buscarPorId(Integer id) { // Usa Integer
        return usuarioRepository.findById(id);
    }
    
    public void eliminar(Integer id) { // Usa Integer
        usuarioRepository.deleteById(id);
    }
}