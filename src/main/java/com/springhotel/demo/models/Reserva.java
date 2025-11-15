package com.springhotel.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name = "reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Long idReserva;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_habitacion", nullable = false)
    private Habitacion habitacion;

    @Column(name = "fecha_checkin")
    private LocalDate fechaCheckin;

    @Column(name = "fecha_checkout")
    private LocalDate fechaCheckout;

    @Column(name = "total_huespedes")
    private int totalHuespedes;

    @Column(name = "precio_total")
    private double precioTotal;

    @NotNull
    @Column(name = "estado_reserva")
    private String estadoReserva;

    @Column(name = "fecha_reserva")
    private LocalDateTime fechaReserva;

    @Column(name = "notas")
    private String notas;

    // Constructor vacío obligatorio para JPA
    public Reserva() {}

    // Constructor completo (opcional para pruebas o carga manual)
    public Reserva(Usuario usuario, Habitacion habitacion, LocalDate fechaCheckin, LocalDate fechaCheckout,
                   int totalHuespedes, double precioTotal, String estadoReserva, String notas) {
        this.usuario = usuario;
        this.habitacion = habitacion;
        this.fechaCheckin = fechaCheckin;
        this.fechaCheckout = fechaCheckout;
        this.totalHuespedes = totalHuespedes;
        this.precioTotal = precioTotal;
        this.estadoReserva = estadoReserva;
        this.notas = notas;
        this.fechaReserva = LocalDateTime.now();
    }

    // Inicializa fechaReserva automáticamente al guardar
    @PrePersist
    protected void onCreate() {
        this.fechaReserva = LocalDateTime.now();
    }

    // Getters y Setters
    public Long getIdReserva() { return idReserva; }
    public void setIdReserva(Long idReserva) { this.idReserva = idReserva; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Habitacion getHabitacion() { return habitacion; }
    public void setHabitacion(Habitacion habitacion) { this.habitacion = habitacion; }

    public LocalDate getFechaCheckin() { return fechaCheckin; }
    public void setFechaCheckin(LocalDate fechaCheckin) { this.fechaCheckin = fechaCheckin; }

    public LocalDate getFechaCheckout() { return fechaCheckout; }
    public void setFechaCheckout(LocalDate fechaCheckout) { this.fechaCheckout = fechaCheckout; }

    public int getTotalHuespedes() { return totalHuespedes; }
    public void setTotalHuespedes(int totalHuespedes) { this.totalHuespedes = totalHuespedes; }

    public double getPrecioTotal() { return precioTotal; }
    public void setPrecioTotal(double precioTotal) { this.precioTotal = precioTotal; }

    public String getEstadoReserva() { return estadoReserva; }
    public void setEstadoReserva(String estadoReserva) { this.estadoReserva = estadoReserva; }

    public LocalDateTime getFechaReserva() { return fechaReserva; }
    public void setFechaReserva(LocalDateTime fechaReserva) { this.fechaReserva = fechaReserva; }

    public String getNotas() { return notas; }
    public void setNotas(String notas) { this.notas = notas; }

    // toString para facilitar binding en formularios
    @Override
    public String toString() {
        return String.valueOf(idReserva);
    }
}