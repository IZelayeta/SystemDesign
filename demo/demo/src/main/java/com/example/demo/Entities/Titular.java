package com.example.demo.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Titular")
public class Titular {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, name = "apellido")
    private String apellido;

    @Column(nullable = false, name = "dni")
    private int dni;

    @Column(nullable = false, name = "nombre")
    private String nombre;
    
}
