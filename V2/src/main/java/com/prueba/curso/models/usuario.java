package com.prueba.curso.models;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="user", schema = "public")
@Getter
@Setter
public class usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="apellido")
    private String apellido;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="telefono")
    private String telefono;





}
