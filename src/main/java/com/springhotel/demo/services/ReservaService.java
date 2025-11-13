package com.springhotel.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springhotel.demo.models.Reserva;
import com.springhotel.demo.models.Usuario;
import com.springhotel.demo.models.Habitacion;
import com.springhotel.demo.repositories.ReservaRepository;
import com.springhotel.demo.repositories.UsuarioRepository;
import com.springhotel.demo.repositories.HabitacionRepository;

import java.time.LocalDateTime;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private HabitacionRepository habitacionRepository;

    public void guardarReserva(Reserva reserva) {
        // Asignación temporal para cumplir con la estructura de la BD

        if (reserva.getUsuario() == null) {
            Usuario usuarioPorDefecto = usuarioRepository.findById(1L).orElse(null);
            reserva.setUsuario(usuarioPorDefecto);
        }

        if (reserva.getHabitacion() == null) {
            Habitacion habitacionPorDefecto = habitacionRepository.findById(101L).orElse(null);
            reserva.setHabitacion(habitacionPorDefecto);
        }

        if (reserva.getPrecioTotal() <= 0) {
            reserva.setPrecioTotal(150.00);
        }

        if (reserva.getEstadoReserva() == null || reserva.getEstadoReserva().isBlank()) {
            reserva.setEstadoReserva("Pendiente");
        }

        if (reserva.getTotalHuespedes() <= 0) {
            reserva.setTotalHuespedes(1);
        }

        if (reserva.getFechaReserva() == null) {
            reserva.setFechaReserva(LocalDateTime.now());
        }

        reservaRepository.save(reserva);
    }
}