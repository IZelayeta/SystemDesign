package com.example.demo.Resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entities.Provincia;
import com.example.demo.Services.ProvinciaBD;

@RestController
@RequestMapping("Provincias")
public class ProviniciaController {
    @Autowired
    ProvinciaBD provinciabd;

    @GetMapping("/listarProvincias")
    public List<Provincia> listarProvincias(){
        return provinciabd.listarProvincias();
    }
}
