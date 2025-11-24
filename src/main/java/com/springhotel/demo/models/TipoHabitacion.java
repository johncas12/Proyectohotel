package com.springhotel.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal; // Recomendado para precisión monetaria

@Entity
@Table(name = "tipos_habitacion")
@Data
@NoArgsConstructor
public class TipoHabitacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_habitacion")
    private Integer idTipoHabitacion; // Tipo Integer

    @Column(name = "nombre_tipo", nullable = false)
    private String nombreTipo; 

    private String descripcion;
    
    @Column(name = "capacidad_maxima", nullable = false)
    private Integer capacidadMaxima;
    
    @Column(name = "precio_noche", nullable = false)
    private BigDecimal precioNoche; 
}