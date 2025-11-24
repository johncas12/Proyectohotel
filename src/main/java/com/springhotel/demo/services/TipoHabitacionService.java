package com.springhotel.demo.services;

import com.springhotel.demo.models.TipoHabitacion;
import com.springhotel.demo.repositories.TipoHabitacionRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TipoHabitacionService {
    // ... Constructor y DI ...
    private final TipoHabitacionRepository tipoHabitacionRepository;
    public TipoHabitacionService(TipoHabitacionRepository tipoHabitacionRepository) {
        this.tipoHabitacionRepository = tipoHabitacionRepository;
    }
    
    // Sustentación: Método CRUD LECTURA (R - Read)
    public List<TipoHabitacion> listarTodas() {
        return tipoHabitacionRepository.findAll();
    }
    
    public Optional<TipoHabitacion> buscarPorId(Integer id) {
        return tipoHabitacionRepository.findById(id); 
    }
    
    // Sustentación: Método CRUD CREACIÓN/ACTUALIZACIÓN (C/U)
    public TipoHabitacion guardar(TipoHabitacion tipoHabitacion) {
        return tipoHabitacionRepository.save(tipoHabitacion);
    }
    
    // Sustentación: Método CRUD ELIMINACIÓN (D - Delete)
    public void eliminar(Integer id) {
        tipoHabitacionRepository.deleteById(id);
    }
}