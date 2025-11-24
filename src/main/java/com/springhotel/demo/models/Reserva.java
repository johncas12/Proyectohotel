package com.springhotel.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@Table(name = "reservas")
@Data
@NoArgsConstructor
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Integer idReserva; // Usa Integer

    @ManyToOne 
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario; // Relación con Usuario

    @ManyToOne 
    @JoinColumn(name = "id_habitacion", nullable = false)
    private Habitacion habitacion; // Relación con Habitacion
    
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_checkin", nullable = false)
    private Date fechaCheckin;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_checkout", nullable = false)
    private Date fechaCheckout;
    
    @Column(name = "total_huespedes", nullable = false)
    private Integer totalHuespedes;

    @Column(name = "precio_total")
    private Double precioTotal; // Calculado por el servicio
    
    @Column(name = "estado_reserva")
    private String estadoReserva;
    
    @Column(name = "fecha_reserva")
    private Date fechaReserva;

    private String notas;
    
    // NOTA: Se omiten 'fecha_llegada' y 'fecha_salida' por ser redundantes con checkin/checkout.
}