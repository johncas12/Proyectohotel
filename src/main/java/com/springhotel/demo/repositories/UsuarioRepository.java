package com.springhotel.demo.repositories;

import com.springhotel.demo.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

// Se eliminó el import innecesario de @Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
}