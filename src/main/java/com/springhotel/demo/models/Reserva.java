package com.springhotel.demo.models;

import java.util.Date;

// --- Imports de JPA (jakarta.persistence) ---
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

// --- Import para el formato de fechas ---
import org.springframework.format.annotation.DateTimeFormat; 

@Entity
@Table(name = "reservas") // Alineación con el nombre de la tabla en la BD
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva") // Clave Primaria según el esquema de la BD
    private Long idReserva;

    // -----------------------------------------------------------------
    // CORRECCIÓN 1: Mapeo de la fecha de creación (Soluciona 'Unknown column')
    // Se mapea 'fechaCreacion' al nombre de la columna real: 'fecha_reserva'
    // -----------------------------------------------------------------
    @Column(name = "fecha_reserva", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    // -----------------------------------------------------------------
    // CORRECCIÓN 2: Formato de Fechas (Soluciona el error 400 'typeMismatch')
    // Indica a Spring cómo parsear la cadena de fecha (yyyy-MM-dd) del formulario HTML
    // -----------------------------------------------------------------
    @Column(name = "fecha_checkin", nullable = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd") 
    private Date fechaCheckin;

    @Column(name = "fecha_checkout", nullable = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaCheckout;
    
    // -----------------------------------------------------------------
    // CORRECCIÓN 3: Mapeo de Claves Foráneas (FKs)
    // Se fuerza el mapeo a las columnas reales de la BD: id_usuario y id_habitacion
    // -----------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false) 
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_habitacion", nullable = false) 
    private Habitacion habitacion;

    // -----------------------------------------------------
    // Otros Campos (Alineación con el esquema BD)
    // -----------------------------------------------------
    @Column(name = "total_huespedes", nullable = false)
    private Integer totalHuespedes;

    @Column(name = "precio_total")
    private Double precioTotal;

    @Column(name = "estado_reserva")
    private String estadoReserva;

    @Column(name = "notas")
    private String notas;
    
    // Nota: Se omiten 'fecha_llegada', 'fecha_salida', 'id_cliente', etc. ya que son redundantes
    // o columnas temporales creadas por Hibernate. Si las necesitas, debes agregarlas aquí.

    // Constructor vacío requerido por JPA
    public Reserva() {}

    // --- Getters y Setters ---

    public Long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaCheckin() {
        return fechaCheckin;
    }

    public void setFechaCheckin(Date fechaCheckin) {
        this.fechaCheckin = fechaCheckin;
    }

    public Date getFechaCheckout() {
        return fechaCheckout;
    }

    public void setFechaCheckout(Date fechaCheckout) {
        this.fechaCheckout = fechaCheckout;
    }

    public Integer getTotalHuespedes() {
        return totalHuespedes;
    }

    public void setTotalHuespedes(Integer totalHuespedes) {
        this.totalHuespedes = totalHuespedes;
    }

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(String estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }
}