package com.example.demo.Resources;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entities.Agremiado;
import com.example.demo.Entities.Consultorio;
import com.example.demo.Entities.ObraSocial;
import com.example.demo.Entities.DTO.AgremiadoDTO;
import com.example.demo.Entities.Enum.Estado;
import com.example.demo.Services.AgremiadoBD;
import com.example.demo.Services.ConsultorioBD;
import com.example.demo.Services.ObraSocialBD;

@RestController
@RequestMapping("/agremiado")
@CrossOrigin(origins = "http://localhost:4200")
public class AgremiadoController {
    
    @Autowired
    AgremiadoBD agremiadoBD;
    @Autowired
    ConsultorioBD consultorioBD;
    @Autowired
    ObraSocialBD obraSocialBD;

    public AgremiadoController(){}

    @GetMapping("/listarAgremiados")
    public ResponseEntity<List<AgremiadoDTO>> buscarAgremiados(@Param(value = "data")String data){
        List<Agremiado> agremiados=agremiadoBD.listarAgremiados().stream().filter(
        a->a.getApellido().toLowerCase().contains(data.toLowerCase()) || 
        a.getNombre().toLowerCase().contains(data.toLowerCase()) || 
        a.getDni().toString().toLowerCase().contains(data.toLowerCase()))
        .collect(Collectors.toList());
        List<AgremiadoDTO> agremiadosDTO=new ArrayList<>();
        for(int i=0;i<agremiados.size();i++){
            String apellido=agremiados.get(i).getApellido();
            String nombre=agremiados.get(i).getNombre();
            String email=agremiados.get(i).getEmail();
            Integer dni=agremiados.get(i).getDni();
            String telefono=agremiados.get(i).getTelefono();
            List<ObraSocial> obrasSociales=agremiados.get(i).getObraSocials();
            List<Consultorio> consultorios=agremiados.get(i).getConsultorios();
            AgremiadoDTO agremiadoDTO=new AgremiadoDTO(apellido, dni, email, nombre, telefono, obrasSociales, consultorios);
            agremiadosDTO.add(agremiadoDTO);
        }
        return ResponseEntity.ok(agremiadosDTO);
    }
    
    @PostMapping("/alta_agremiado")
    public ResponseEntity<Agremiado> alta_agremiado(@RequestBody AgremiadoDTO agremiadoDTO){
        Agremiado agremiado=new Agremiado();
        if(this.agremiadoBD.findByDni(agremiadoDTO.getDni()).isEmpty()){
            agremiado.setDni(agremiadoDTO.getDni());
            agremiado.setApellido(agremiadoDTO.getApellido());
            agremiado.setEmail(agremiadoDTO.getEmail());
            agremiado.setEstado(Estado.Deudor);
            agremiado.setNombre(agremiadoDTO.getNombre());
            agremiado.setTelefono(agremiadoDTO.getTelefono());
            agremiado.setObraSocials(obraSocialBD.buscarObrasSociales(agremiadoDTO.getObraSocials()));
            agremiado.setConsultorios(consultorioBD.buscarConsultorios(agremiadoDTO.getConsultorios()));
            agremiadoBD.persistir(agremiado);
            return ResponseEntity.ok(agremiado);
        }else{
            return ResponseEntity.ok(agremiado);
        }
    }
}
