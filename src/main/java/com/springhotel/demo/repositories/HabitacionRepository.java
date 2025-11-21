package com.springhotel.demo.repositories;

import com.springhotel.demo.models.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Repositorio para la entidad Habitacion.
 * Incluye un método personalizado (Query Method) para la consulta de estado.
 */
@Repository
public interface HabitacionRepository extends JpaRepository<Habitacion, Long> {
    
    /**
     * Ejemplo de Query Method: Spring genera el SQL: SELECT * FROM habitaciones WHERE estado = ?
     * 🔹 Argumento Académico: Demuestra el poder de las Query Methods de Spring Data JPA,
     * permitiendo definir consultas complejas sin escribir SQL puro.
     */
    List<Habitacion> findByEstado(String estado);
}