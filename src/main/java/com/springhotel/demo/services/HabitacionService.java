package com.springhotel.demo.services;

import com.springhotel.demo.models.Habitacion;
import com.springhotel.demo.repositories.HabitacionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Servicio encargado de la lógica de negocio de la entidad Habitacion.
 * Implementa las validaciones de negocio y el acceso a datos.
 */
@Service
@Transactional
public class HabitacionService {

    private final HabitacionRepository habitacionRepository;

    // Inyección de Dependencias por Constructor
    public HabitacionService(HabitacionRepository habitacionRepository) {
        this.habitacionRepository = habitacionRepository;
    }

    /**
     * Devuelve la lista completa de todas las habitaciones.
     */
    public List<Habitacion> listarTodas() {
        return habitacionRepository.findAll();
    }

    /**
     * Busca y devuelve una Habitacion por su ID.
     */
    public Habitacion obtenerPorId(Long id) {
        if (id == null) {
            throw new RuntimeException("El ID de habitación no puede ser nulo.");
        }
        return habitacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Habitación con ID " + id + " no encontrada."));
    }

    /**
     * Guarda o actualiza una Habitacion, aplicando validaciones de negocio.
     */
    public Habitacion guardar(Habitacion h) {
        // Validación de negocio en la capa Service
        if (h == null || h.getNumeroHabitacion() == null || h.getPrecioNoche() <= 0) {
            throw new RuntimeException("Datos de habitación inválidos: número y precio son obligatorios.");
        }
        
        return habitacionRepository.save(h);
    }

    /**
     * Elimina una Habitacion por su ID.
     */
    public void eliminar(Long id) {
        if (id == null) {
            throw new RuntimeException("El ID de habitación no puede ser nulo para eliminar.");
        }
        // En un sistema real, se debería primero verificar si está en uso.
        habitacionRepository.deleteById(id);
    }
}