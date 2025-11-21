package com.springhotel.demo.services;

import com.springhotel.demo.models.Reserva;
import com.springhotel.demo.repositories.ReservaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException; // Necesario para la excepción de 'obtenerPorId'

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;

    // Inyección de Dependencia por Constructor. 
    // Esto elimina la necesidad de 'import org.springframework.beans.factory.annotation.Autowired'
    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    // 1. Método CORREGIDO: Renombrado de 'listar()' a 'listarTodas()'
    public List<Reserva> listarTodas() {
        return reservaRepository.findAll();
    }

    // Método para guardar o actualizar una reserva
    public Reserva guardar(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    // 2. Método CORREGIDO: Renombrado de 'obtener(Long id)' a 'obtenerPorId(Long id)'
    // Esto elimina la advertencia de 'import java.util.Optional' si se usa orElseThrow
    public Reserva obtenerPorId(Long id) {
        return reservaRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Reserva no encontrada con ID: " + id)
        );
    }

    // Método para eliminar una reserva
    public void eliminar(Long id) {
        reservaRepository.deleteById(id);
    }
}