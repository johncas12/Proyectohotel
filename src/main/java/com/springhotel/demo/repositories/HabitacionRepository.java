package com.springhotel.demo.repositories;

import com.springhotel.demo.models.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface HabitacionRepository extends JpaRepository<Habitacion, Long> {

    // Opcional: para mostrar solo habitaciones disponibles en el formulario de reservas
    List<Habitacion> findByEstado(String estado);
}