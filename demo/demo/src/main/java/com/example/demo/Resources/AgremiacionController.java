package com.example.demo.Resources;

import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
import com.fasterxml.jackson.databind.ObjectMapper;

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

    @GetMapping("{filename:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String filename) throws IOException{
        Resource file=storageService.loadAsResources(filename);
        String contentType= Files.probeContentType(file.getFile().toPath());
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, contentType).body(file);
    }

    @PostMapping("/agremiar")
    public ResponseEntity<Agremiacion> agremiar(@RequestPart("agremiadoDTO") String agremiadoDTO, @RequestPart ("file") MultipartFile matricula) throws IOException{
        
        storageService.init();
        ObjectMapper objectMapper=new ObjectMapper();
        AgremiadoDTO agremiadoDTO2=objectMapper.readValue(agremiadoDTO, AgremiadoDTO.class);

        Agremiado agremiadoReal = agremiadoBD.findByDni(agremiadoDTO2.getDni()).get();
        Agremiacion agremiacion=new Agremiacion();
        agremiacion.setOdontologo(agremiadoReal);

        String path = storageService.store(matricula);
        String host = request.getRequestURL().toString().replace(request.getRequestURI(), "");
        String url = ServletUriComponentsBuilder.fromHttpUrl(host).path("/Agremiacion/").path(path).toUriString();
        agremiacion.setMatricula(url);
        
        agremiacion.setCodigo(agremiacionBD.ultimoCodigo()+1);
        agremiacion.setFechaDeAlta(LocalDate.now());
        agremiacion.cargarCuotas(agremiacion.crearCuotas());
        
        agremiacionBD.persistir(agremiacion);
        return ResponseEntity.ok(agremiacion);
    }

}
