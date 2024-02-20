package com.example.demo.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Entities.Consultorio;
import com.example.demo.Entities.Localidad;

@Repository
public interface IConsultorioRepository extends CrudRepository<Consultorio,Integer>{
    
    @Query(value = "select c.id from consultorio c join localidad l on c.localidad_id=l.id join provincia p on l.provincia_id=p.id where c.calle=:calle and c.numero=:numero and l.nombre=:nombreLocalidad and p.nombre=:nombreProvincia", nativeQuery = true)
    public int buscarConsultorio(@Param("calle")String calle, @Param("numero")String numero, @Param("nombreLocalidad")String nombreLocalidad, @Param("nombreProvincia")String nombreProvincia);
    public Consultorio findByCalleAndNumeroAndLocalidad(String calle,String numero,Localidad localidad);

    public Localidad findByLocalidad(Localidad localidad);


}
