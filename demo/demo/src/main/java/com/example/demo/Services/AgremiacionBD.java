package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Agremiacion;
import com.example.demo.Repository.IAgremiacionRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AgremiacionBD {
    
    @Autowired
    IAgremiacionRepository agremiacionRepository;

    public AgremiacionBD(){}

    public void persistir(Agremiacion agremiacion){
        agremiacionRepository.save(agremiacion);
    }

    public Integer ultimoCodigo(){
        Integer codigo=agremiacionRepository.ultimoCodigo();
        if (codigo == null) {
            return 0;
        }
        return codigo;
    }
}
