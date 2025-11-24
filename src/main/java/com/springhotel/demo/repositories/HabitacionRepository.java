package com.springhotel.demo.repositories;

import com.springhotel.demo.models.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitacionRepository extends JpaRepository<Habitacion, Integer> { 
    
}