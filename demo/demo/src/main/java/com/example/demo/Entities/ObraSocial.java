package com.example.demo.Entities;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ObraSocial")
public class ObraSocial {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, name = "nombre")
    private String nombre;

    @Column(nullable = false, name = "registroNacional")
    private String registroNacional;

    @ManyToMany(mappedBy = "obraSocials")
    private List<Agremiado> agremiados;

    public ObraSocial() {}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRegistroNacional() {
        return registroNacional;
    }

    public void setRegistroNacional(String registroNacional) {
        this.registroNacional = registroNacional;
    }
    
}
