package com.springhotel.demo.repositories;

import com.springhotel.demo.models.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la entidad Reserva.
 * Es la pieza central del negocio.
 */
@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    // Por ahora solo necesitamos las operaciones CRUD estándar.
}