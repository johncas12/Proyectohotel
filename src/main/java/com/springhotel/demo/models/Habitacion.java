package com.springhotel.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * 🔹 Entidad Habitacion
 * Define las características físicas y comerciales de la habitación.
 */
@Entity
@Table(name = "habitaciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Habitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_habitacion")
    private Long idHabitacion;

    // 🔒 El número es único y obligatorio.
    @Column(name = "numero_habitacion", nullable = false, unique = true)
    private String numeroHabitacion;

    @Column(name = "capacidad", nullable = false)
    private int capacidad;

    @Column(name = "precio_noche", nullable = false)
    private double precioNoche;

    @Column(name = "tipo", nullable = false)
    private String tipo; // Ej: SIMPLE, DOBLE, SUITE

    @Column(name = "estado", nullable = false)
    private String estado; // Ej: DISPONIBLE, OCUPADA, LIMPIEZA

    // Argumento de Defensa Académica:
    // El uso de campos primitivos (int, double) con la restricción 'nullable = false'
    // asegura que la entidad cumple con la atomicidad de datos y evita que la lógica
    // de negocio dependa de valores nulos para datos esenciales como el precio o la capacidad.
}