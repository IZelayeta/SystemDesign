package com.example.demo.Resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entities.Consultorio;
import com.example.demo.Services.ConsultorioBD;

@RestController
@RequestMapping("/consultorio")
public class ConsultorioController {
    
    @Autowired
    ConsultorioBD consultorioBD;

    public ConsultorioController(){}

    @GetMapping("/listarConsultorios")
    public ResponseEntity<List<Consultorio>> listarConsultorio(){
        return ResponseEntity.ok(consultorioBD.listarConsultorios());
    }
}
