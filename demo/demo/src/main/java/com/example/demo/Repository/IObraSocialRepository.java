package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entities.ObraSocial;

@Repository
public interface IObraSocialRepository extends CrudRepository<ObraSocial,Integer>{
    
    public ObraSocial findByNombre(String nombre);
}
