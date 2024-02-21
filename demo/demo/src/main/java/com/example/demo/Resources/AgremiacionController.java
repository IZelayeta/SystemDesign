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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.Entities.Agremiacion;
import com.example.demo.Entities.Agremiado;
import com.example.demo.Entities.DTO.AgremiadoDTO;
import com.example.demo.Services.AgremiacionBD;
import com.example.demo.Services.AgremiadoBD;
import com.example.demo.Services.StorageService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;



@RestController
@RequestMapping("/Agremiacion")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class AgremiacionController {

    @Autowired
    AgremiacionBD agremiacionBD;
    @Autowired
    AgremiadoBD agremiadoBD;

    private final StorageService storageService;
    private final HttpServletRequest request;
    
    @GetMapping("/ultimoCodigo")
    public ResponseEntity<Integer> ultimoNumero(){
        return ResponseEntity.ok(this.agremiacionBD.ultimoCodigo());
    }

    @PostMapping("/agremiar")
    public ResponseEntity<Agremiacion> agremiar(@RequestBody AgremiadoDTO agremiadoDTO, @RequestPart ("file") MultipartFile matricula){
        Agremiado agremiadoReal = agremiadoBD.findByDni(agremiadoDTO.getDni()).get();
        Agremiacion agremiacion=new Agremiacion();
        agremiacion.setOdontologo(agremiadoReal);

        String path = storageService.store(matricula);
        String host = request.getRequestURL().toString().replace(request.getRequestURI(), "");
        String url = ServletUriComponentsBuilder.fromHttpUrl(host).path("/media/").path(path).toUriString();
        agremiacion.setMatricula(url);
        
        agremiacion.setCodigo(agremiacionBD.ultimoCodigo()+1);
        agremiacion.setFechaDeAlta(LocalDate.now());
        agremiacion.cargarCuotas(agremiacion.crearCuotas());
        
        agremiacionBD.persistir(agremiacion);
        return ResponseEntity.ok(agremiacion);
    }

}
