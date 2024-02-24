package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Provincia;
import com.example.demo.Repository.IProvinciaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProvinciaBD {
    @Autowired
    IProvinciaRepository provinciaRepository;

    public List<Provincia> listarProvincias(){
        return (List<Provincia>) provinciaRepository.findAll();
    }
}
