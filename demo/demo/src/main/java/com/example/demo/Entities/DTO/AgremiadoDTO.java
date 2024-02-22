package com.example.demo.Entities.DTO;


import java.util.List;

import com.example.demo.Entities.Consultorio;
import com.example.demo.Entities.ObraSocial;

import lombok.Data;

@Data
public class AgremiadoDTO {
    private String apellido;
    private Integer dni;
    private String email;
    private String nombre;
    private String telefono;
    private List<ObraSocial> obraSocials;
    private List<Consultorio> consultorios;


    public AgremiadoDTO(){}
    
    public AgremiadoDTO(String apellido, Integer dni, String email, String nombre, String telefono, List<ObraSocial> obraSocials, List<Consultorio> consultorios) {
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.nombre = nombre;
        this.telefono = telefono;
        this.obraSocials = obraSocials;
        this.consultorios = consultorios;
    }
}
