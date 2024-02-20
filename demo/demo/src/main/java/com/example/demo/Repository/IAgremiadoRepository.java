package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entities.Agremiado;


@Repository
public interface IAgremiadoRepository extends CrudRepository<Agremiado,Integer>{
    Optional <Agremiado> findByDni(Integer dni);
}