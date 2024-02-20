package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Agremiado;

import com.example.demo.Repository.IAgremiadoRepository;
import com.example.demo.Repository.IConsultorioRepository;
import com.example.demo.Repository.ILocalidadRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AgremiadoBD {
    @Autowired
    IAgremiadoRepository agremiadoRepository;
    @Autowired
    ILocalidadRepository localidadRepository;
    @Autowired
    IConsultorioRepository consultorioRepository;

    public AgremiadoBD(){}

    public Optional <Agremiado> findByDni(Integer dni){
        return agremiadoRepository.findByDni(dni);
    }

    public void persistir(Agremiado agremiado){
        agremiadoRepository.save(agremiado);
    }

    public List<Agremiado> listarAgremiados(){
        return (List<Agremiado>)this.agremiadoRepository.findAll();
    }
}
