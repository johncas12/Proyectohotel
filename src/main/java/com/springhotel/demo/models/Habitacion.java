package com.springhotel.demo.models;

import jakarta.persistence.*;
import com.springhotel.demo.models.TipoHabitacion; // Importación necesaria
import java.io.Serializable;

@Entity
@Table(name = "habitaciones")
public class Habitacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "id_habitacion")
    private Integer idHabitacion; // CLAVE PRIMARIA: Usar Integer (INT en DB)

    @Column(name = "numero_habitacion")
    private String numeroHabitacion;

    @Column(name = "estado")
    private String estado;
    
    @Column(name = "capacidad")
    private Integer capacidad;
    
    @Column(name = "precio_noche")
    private Double precioNoche;
    
    // Relación ManyToOne
    @ManyToOne
    @JoinColumn(name = "id_tipo_habitacion")
    private TipoHabitacion tipoHabitacion; 
    
    @Column(name = "tipo")
    private String tipo;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "disponible")
    private Boolean disponible;
    
    @Column(name = "precio")
    private Double precio;

    public Habitacion() {}

    // Getters y Setters...
    public Integer getIdHabitacion() { return idHabitacion; }
    public void setIdHabitacion(Integer idHabitacion) { this.idHabitacion = idHabitacion; }
    public String getNumeroHabitacion() { return numeroHabitacion; }
    public void setNumeroHabitacion(String numeroHabitacion) { this.numeroHabitacion = numeroHabitacion; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public Integer getCapacidad() { return capacidad; }
    public void setCapacidad(Integer capacidad) { this.capacidad = capacidad; }
    public Double getPrecioNoche() { return precioNoche; }
    public void setPrecioNoche(Double precioNoche) { this.precioNoche = precioNoche; }
    public TipoHabitacion getTipoHabitacion() { return tipoHabitacion; }
    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) { this.tipoHabitacion = tipoHabitacion; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public Boolean getDisponible() { return disponible; }
    public void setDisponible(Boolean disponible) { this.disponible = disponible; }
    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }
}