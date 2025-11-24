package com.springhotel.demo.services;

// IMPORTS FALTANTES CLAVE
import com.springhotel.demo.models.Reserva;
import com.springhotel.demo.repositories.ReservaRepository;
import org.springframework.stereotype.Service;
import java.util.Date; // Soluciona 'Date cannot be resolved'
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservaService {
    
    private final ReservaRepository reservaRepository;
    private final HabitacionService habitacionService; // Para el cálculo de precio
    
    public ReservaService(ReservaRepository reservaRepository, HabitacionService habitacionService) {
        this.reservaRepository = reservaRepository;
        this.habitacionService = habitacionService;
    }
    
    public List<Reserva> listarTodas() {
        return reservaRepository.findAll();
    }
    
    public Optional<Reserva> buscarPorId(Integer id) { // Usa Integer
        return reservaRepository.findById(id);
    }

    public void eliminar(Integer id) { // Usa Integer
        reservaRepository.deleteById(id);
    }
    
    @Transactional
    public Reserva guardar(Reserva reserva) {
        if (reserva.getFechaReserva() == null) {
            reserva.setFechaReserva(new Date()); 
        }

        // Lógica de negocio para calcular el precio total
        Integer idHabitacion = reserva.getHabitacion().getIdHabitacion();

        habitacionService.buscarPorId(idHabitacion)
            .ifPresent(habitacion -> {
                Double precioNoche = habitacion.getPrecioNoche();

                // Cálculo de días de estadía
                long diff = reserva.getFechaCheckout().getTime() - reserva.getFechaCheckin().getTime();
                long diffDays = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
                if (diffDays == 0) diffDays = 1; // Mínimo una noche

                if (precioNoche != null && diffDays > 0) {
                    double precioTotal = precioNoche * diffDays;
                    reserva.setPrecioTotal(precioTotal);
                } else {
                    reserva.setPrecioTotal(0.0);
                }
            });
            
        return reservaRepository.save(reserva);
    }
}