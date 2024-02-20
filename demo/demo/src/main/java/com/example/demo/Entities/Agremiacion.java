package com.example.demo.Entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.Entities.Conf.Configuracion;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Agremiacion")
public class Agremiacion {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, name = "codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(nullable = false, name = "fechaDeAlta")
    private LocalDate fechaDeAlta;

    @Column(nullable = true, name = "fechaDeBaja")
    private LocalDate fechaDeBaja;

    @Column(nullable = false, name = "matricula")
    private String matricula;

    @JoinColumn(nullable = false, name = "agremiadoId")
    @ManyToOne
    private Agremiado odontologo;

    @JoinColumn(nullable = false, name = "agremiacionId")
    @OneToMany(cascade = {CascadeType.MERGE ,CascadeType.PERSIST})
    private List<Cuota> cuotas;

    public Agremiacion() {
        this.fechaDeBaja = null;
        this.cuotas = new ArrayList<>();
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFechaDeAlta() {
        return fechaDeAlta;
    }

    public void setFechaDeAlta(LocalDate fechaDeAlta) {
        this.fechaDeAlta = fechaDeAlta;
    }

    public LocalDate getFechaDeBaja() {
        return fechaDeBaja;
    }

    public void setFechaDeBaja(LocalDate fechaDeBaja) {
        this.fechaDeBaja = fechaDeBaja;
    }

    public String getMatricula(){
        return matricula;
    }

    public void setMatricula(String matricula){
        this.matricula=matricula;
    }

    public Agremiado getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Agremiado odontologo) {
        this.odontologo = odontologo;
    }

    public List<Cuota> getCuotas() {
        return cuotas;
    }

    public void setCuotas(List<Cuota> cuotas) {
        this.cuotas = cuotas;
    }

    public void cargarCuotas(List<Cuota> cuotas){
        for(int i=0;i<cuotas.size();i++){
            this.cuotas.add(cuotas.get(i));
        }
    }

    public List<Cuota> crearCuotas(){
        LocalDate fechaEmision=LocalDate.now();
        LocalDate fechaVencimiento=LocalDate.now().plusDays(10);
        Configuracion conf=Configuracion.getInstance();
        List<Cuota> cuotas=new ArrayList<>();
        int cantCuotas=13 - LocalDate.now().getMonthValue();
        Float montoMensual=conf.getMontoAnual()/12;
        

        for(int i=0;i<cantCuotas;i++){
            Cuota cuota=new Cuota();
            cuota.setFechaEmision(fechaEmision.plusMonths(i));
            cuota.setFechaVencimiento(fechaVencimiento.plusMonths(i));
            cuota.setMontoMensual(montoMensual);
            cuotas.add(cuota);
        }
        return cuotas;
    }

}
