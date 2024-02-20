package com.example.demo.Resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entities.ObraSocial;
import com.example.demo.Services.ObraSocialBD;

@RestController
@RequestMapping("obraSocial")
public class ObraSocialController {
    
    @Autowired
    ObraSocialBD obraSocialBD;

    public ObraSocialController(){}

    @GetMapping("/listarObraSociales")
    public ResponseEntity<List<ObraSocial>> listarObraSociales(){
        return ResponseEntity.ok(obraSocialBD.listarObraSociales());
    }
}
