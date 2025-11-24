package com.springhotel.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
// import lombok.AllArgsConstructor; // Podrías agregarlo si lo necesitas

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Tipo Integer (soluciona el error de tipo)
    
    @Column(nullable = false)
    private String nombre; 
    
    @Column(nullable = false)
    private String apellido;
    
    @Column(nullable = false, unique = true)
    private String email;
    
    @Column(name = "password_hash", nullable = false)
    private String passwordHash;
    
    private String telefono;
    
    @Column(name = "tipousuario") // Se corrige el mapeo a 'tipousuario' de la DB
    private String tipoUsuario;
    
    @Column(name = "fecharegistro") // Se corrige el mapeo a 'fecharegistro' de la DB
    private Date fechaRegistro;
}