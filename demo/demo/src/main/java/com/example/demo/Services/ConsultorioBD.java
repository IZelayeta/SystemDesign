package com.example.demo.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Consultorio;
import com.example.demo.Entities.Localidad;
import com.example.demo.Entities.Provincia;
import com.example.demo.Repository.IConsultorioRepository;
import com.example.demo.Repository.ILocalidadRepository;
import com.example.demo.Repository.IProvinciaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ConsultorioBD {
    
    @Autowired
    IConsultorioRepository consultorioRepository;
    @Autowired
    ILocalidadRepository localidadRepository;
    @Autowired
    IProvinciaRepository provinciaRepository;

    public Consultorio buscarConsultorio(String calle, String numero, String localidad){
        Localidad localidad2 = localidadRepository.findByNombre(localidad); 
        return this.consultorioRepository.findByCalleAndNumeroAndLocalidad(calle, numero, localidad2);
    }

    public List<Consultorio> buscarConsultorios(List<Consultorio> consultorios){
        List<Consultorio> consultoriosReales=new ArrayList<>();
        for(int i=0;i<consultorios.size();i++){
            //Localidad localidadExistente=this.buscarLocalidad(consultorios.get(i).getLocalidad().getNombre());
            //Provincia provinciaExistente=this.buscarProvincia(consultorios.get(i).getLocalidad().getProvincia().getNombre());
            //Consultorio consultorioExistente=this.buscarXCalleyNumeroyLocalidad(consultorios.get(i).getCalle(), consultorios.get(i).getNumero(),localidadExistente);
            Integer consultorioExistenteId=this.consultorioRepository.buscarConsultorio(consultorios.get(i).getCalle(), consultorios.get(i).getNumero(), consultorios.get(i).getLocalidad().getNombre(), consultorios.get(i).getLocalidad().getProvincia().getNombre());
            Consultorio consultorioExistente=this.consultorioRepository.findById(consultorioExistenteId).get();
            consultoriosReales.add(consultorioExistente);
        }
        return consultoriosReales;
    }

    public Consultorio buscarXCalleyNumeroyLocalidad(String calle, String numero, Localidad localidad){
        return this.consultorioRepository.findByCalleAndNumeroAndLocalidad(calle, numero,localidad);
    }

    public Localidad buscarLocalidad(String nombre){
        return this.localidadRepository.findByNombre(nombre);
    }

    public Provincia buscarProvincia(String nombre){
        return this.provinciaRepository.findByNombre(nombre);
    }
    
}
