package com.springhotel.demo.repositories;

import com.springhotel.demo.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la entidad Usuario.
 * 🔹 Argumento Académico: Al extender JpaRepository, evitamos escribir código
 * para métodos básicos (como INSERT, SELECT ALL, UPDATE), adhiriéndonos al
 * principio DRY (Don't Repeat Yourself) y utilizando la abstracción de Spring Data JPA.
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Métodos findBy... pueden ser añadidos aquí si fueran necesarios (ej: findByEmail)
}