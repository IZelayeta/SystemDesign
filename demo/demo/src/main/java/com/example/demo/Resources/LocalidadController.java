package com.example.demo.Resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entities.Localidad;
import com.example.demo.Services.LocalidadBD;

@RestController
@RequestMapping("Localidades")
public class LocalidadController {
    @Autowired
    LocalidadBD localidadbd;

    @GetMapping("/listarLocalidades")
    public List<Localidad> listarLocalidades(String nombre){
        return localidadbd.listarLocalidades(nombre);
    }
}
