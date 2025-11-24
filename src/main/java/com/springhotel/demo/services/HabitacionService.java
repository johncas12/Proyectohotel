package com.springhotel.demo.services;

import com.springhotel.demo.models.Habitacion;
import com.springhotel.demo.repositories.HabitacionRepository; 
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class HabitacionService {
    private final HabitacionRepository habitacionRepository;

    public HabitacionService(HabitacionRepository habitacionRepository) {
        this.habitacionRepository = habitacionRepository;
    }
    
    // El método se llama 'buscarPorId' (resolviendo error 'obtenerPorId') y usa Integer
    public Optional<Habitacion> buscarPorId(Integer id) { 
        return habitacionRepository.findById(id); 
    }
    
    public void eliminar(Integer id) { // Usa Integer
        habitacionRepository.deleteById(id);
    }
    
    public List<Habitacion> listarTodas() {
        return habitacionRepository.findAll();
    }
    
    public Habitacion guardar(Habitacion habitacion) {
        return habitacionRepository.save(habitacion);
    }
}