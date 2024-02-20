package com.example.demo.Entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Localidad")
public class Localidad {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, name = "nombre", unique = true)
    private String nombre;

    @JoinColumn(nullable = false, name = "provinciaId")
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Provincia provincia;

    public Localidad() {}

    public Provincia getProvincia() {
        return provincia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

}
