package com.example.demo.Entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="Consultorio")
public class Consultorio {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, name = "calle")
    private String calle;

    @Column(nullable = false, name = "certificadoSH")
    private String certificadoSH;

    @Column(nullable = false, name = "numero")
    private String numero;

    @JoinColumn(nullable = false, name = "localidadId")
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Localidad localidad;
    
    @ManyToMany(mappedBy = "consultorios", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Agremiado> agremiados;

    public Consultorio() {}

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCertificadoSH() {
        return certificadoSH;
    }

    public void setCertificadoSH(String certificadoSH) {
        this.certificadoSH = certificadoSH;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }
    
}
