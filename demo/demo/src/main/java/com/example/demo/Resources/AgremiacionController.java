package com.example.demo.Resources;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entities.Agremiacion;
import com.example.demo.Entities.Agremiado;
import com.example.demo.Entities.DTO.AgremiadoDTO;
import com.example.demo.Services.AgremiacionBD;
import com.example.demo.Services.AgremiadoBD;



@RestController
@RequestMapping("/Agremiacion")
@CrossOrigin(origins = "http://localhost:4200")
public class AgremiacionController {

    @Autowired
    AgremiacionBD agremiacionBD;
    @Autowired
    AgremiadoBD agremiadoBD;

    public AgremiacionController(){}
    
    @GetMapping("/ultimoCodigo")
    public ResponseEntity<Integer> ultimoNumero(){
        return ResponseEntity.ok(this.agremiacionBD.ultimoCodigo());
    }

    @PostMapping("/agremiar")
    public ResponseEntity<Agremiacion> agremiar(@RequestBody AgremiadoDTO agremiadoDTO, @Param(value = "matricula") String matricula){
        Agremiado agremiadoReal = agremiadoBD.findByDni(agremiadoDTO.getDni()).get();
        Agremiacion agremiacion=new Agremiacion();
        agremiacion.setOdontologo(agremiadoReal);
        agremiacion.setMatricula(matricula);
        agremiacion.setCodigo(agremiacionBD.ultimoCodigo()+1);
        agremiacion.setFechaDeAlta(LocalDate.now());
        agremiacion.cargarCuotas(agremiacion.crearCuotas());
        
        agremiacionBD.persistir(agremiacion);
        return ResponseEntity.ok(agremiacion);
    }

}
