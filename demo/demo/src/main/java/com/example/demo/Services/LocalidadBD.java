package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Localidad;
import com.example.demo.Entities.Provincia;
import com.example.demo.Repository.ILocalidadRepository;
import com.example.demo.Repository.IProvinciaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class LocalidadBD {
    @Autowired
    ILocalidadRepository localidadRepository;
    @Autowired
    IProvinciaRepository provinciaRepository;

    public List<Localidad> listarLocalidades(String nombre){
        Provincia provincia = provinciaRepository.findByNombre(nombre);
        return (List<Localidad>) localidadRepository.findByProvincia(provincia);
    }
}
