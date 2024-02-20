package com.example.demo.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.ObraSocial;
import com.example.demo.Repository.IObraSocialRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ObraSocialBD {
    
    @Autowired
    IObraSocialRepository obraSocialRepository;

    public List<ObraSocial> listarObraSociales(){
        return (List<ObraSocial>)this.obraSocialRepository.findAll();
    }

    public List<ObraSocial> buscarObrasSociales(List<ObraSocial> obrasSociales){
        List<ObraSocial> obrasSocialesReales=new ArrayList<>();
        for(int i=0;i<obrasSociales.size();i++){
            ObraSocial obraSocial=this.buscarObraSocial(obrasSociales.get(i).getNombre());
            obrasSocialesReales.add(obraSocial);
        }
        return obrasSocialesReales;
    }

    public ObraSocial buscarObraSocial(String nombre){
        return this.obraSocialRepository.findByNombre(nombre);
    }
}
