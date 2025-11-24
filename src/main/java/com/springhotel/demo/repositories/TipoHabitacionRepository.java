package com.springhotel.demo.repositories;

import com.springhotel.demo.models.TipoHabitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Sustentación: JpaRepository<Entidad, TipoPK>. Se usa Integer para la PK.
@Repository
public interface TipoHabitacionRepository extends JpaRepository<TipoHabitacion, Integer> {}