package com.springhotel.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

/**
 * 🔹 Entidad Usuario (Cliente/Huésped)
 * Representa la tabla 'usuarios'. Se utiliza Lombok (@Data) para generar el boilerplate.
 */
@Entity
@Table(name = "usuarios")
@Data // Genera getters, setters, toString, equals y hashCode de Lombok.
@NoArgsConstructor // Genera el constructor vacío (necesario para JPA).
@AllArgsConstructor // Genera el constructor con todos los argumentos.
public class Usuario {

    // 🔑 CLAVE PRIMARIA: id (Auto-incremental)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idUsuario; // Renombrado a idUsuario para mejor distinción en el código.

    // 🔒 CAMPOS DE NEGOCIO Y AUTENTICACIÓN
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellido", nullable = false)
    private String apellido;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "tipousuario")
    private String tipoUsuario; // Ej: CLIENTE, ADMIN

    @Column(name = "fecharegistro", nullable = false)
    private LocalDateTime fechaRegistro = LocalDateTime.now(); // Valor por defecto.

    // Argumento de Defensa Académica:
    // La clave primaria se renombra internamente a 'idUsuario' para seguir el estándar de Java,
    // pero se mapea con 'id' en la base de datos (name = "id"), demostrando la correcta
    // separación entre el modelo lógico y el físico.

}