package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entities.Provincia;

@Repository
public interface IProvinciaRepository extends CrudRepository<Provincia,Integer>{
    
    public Provincia findByNombre(String nombre);
}
