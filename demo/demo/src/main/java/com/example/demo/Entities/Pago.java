package com.example.demo.Entities;

import java.sql.Time;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Pago")
public class Pago {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, name = "codigo")
    private int codigo;

    @Column(nullable = false, name = "fecha")
    private Date fecha;

    @Column(nullable = false, name = "hora")
    private Time hora;

    @Column(nullable = false, name = "montoNeto")
    private Float montoNeto;

    @JoinColumn(nullable = true, name = "tarjetaId")
    @OneToOne
    private Tarjeta tarjeta;

    @JoinColumn(nullable = true, name = "transferenciaId")
    @OneToOne
    private Transferencia transferencia;


    public Pago() {
        this.tarjeta=null;
        this.transferencia=null;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Float getMontoNeto() {
        return montoNeto;
    }

    public void setMontoNeto(Float montoNeto) {
        this.montoNeto = montoNeto;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public Transferencia getTransferencia() {
        return transferencia;
    }

    public void setTransferencia(Transferencia transferencia) {
        this.transferencia = transferencia;
    }

    
}
