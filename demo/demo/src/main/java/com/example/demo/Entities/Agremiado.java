package com.example.demo.Entities;

import java.util.List;

import com.example.demo.Entities.Enum.Estado;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Agremiado")
public class Agremiado {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, name = "apellido")
    private String apellido;

    @Column(nullable = false, name = "dni", unique = true)
    private Integer dni;

    @Column(nullable = false, name = "email")
    private String email;

    @Column(nullable = false, name = "estado")
    private Estado estado;

    @Column(nullable = false, name = "nombre")
    private String nombre;

    @Column(nullable = false, name = "telefono")
    private String telefono;
    
    @OneToMany(mappedBy = "odontologo")
    private List<Agremiacion> agremiacion;

    @JoinTable(
        name = "AgremiadoObraSocial",
        joinColumns = @JoinColumn(name = "agremiadoId", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "obraSocialId", referencedColumnName = "id")
    )
    @ManyToMany
    private List<ObraSocial> obraSocials;

    @JoinTable(
        name = "AgremiadoConsultorio",
        joinColumns = @JoinColumn(name = "agremiadoId", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "consultorioId", referencedColumnName = "id")
    )
    @ManyToMany
    private List<Consultorio> consultorios;

    public Agremiado() {}

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<ObraSocial> getObraSocials() {
        return obraSocials;
    }

    public void setObraSocials(List<ObraSocial> obraSocials) {
        this.obraSocials = obraSocials;
    }

    public List<Consultorio> getConsultorios() {
        return consultorios;
    }

    public void setConsultorios(List<Consultorio> consultorios) {
        this.consultorios = consultorios;
    }
}
