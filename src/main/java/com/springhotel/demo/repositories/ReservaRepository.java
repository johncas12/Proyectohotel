package com.springhotel.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springhotel.demo.models.Reserva;


// JpaRepository toma dos parámetros:
// 1. La clase de la entidad (Reserva)
// 2. El tipo de dato de la clave primaria (Long, que es idReserva)
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    // Listo: Spring crea automáticamente los métodos CRUD (save, findById, etc.)
}