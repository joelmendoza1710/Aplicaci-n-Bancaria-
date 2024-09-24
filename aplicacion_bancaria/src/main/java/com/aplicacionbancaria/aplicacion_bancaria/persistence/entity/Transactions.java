package com.aplicacionbancaria.aplicacion_bancaria.persistence.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "transacciones")
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "cuenta_origen_id")
    private Integer cuentaOrigenId;

    public Integer getCuentaOrigenId() {
        return cuentaOrigenId;
    }

    public void setCuentaOrigenId(Integer cuentaOrigenId) {
        this.cuentaOrigenId = cuentaOrigenId;
    }

    @Column(name = "cuenta_destino_id")
    private Integer cuentaDestinoId;

    public Integer getCuentaDestinoId() {
        return cuentaDestinoId;
    }

    public void setCuentaDestinoId(Integer cuentaDestinoId) {
        this.cuentaDestinoId = cuentaDestinoId;
    }

    private LocalDateTime fecha;

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    private Integer monto;

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    private String descripcion;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @ManyToOne
    @JoinColumn(name = "cuenta_origen_id",insertable = false,updatable = false)
    @JoinColumn(name = "cuenta_destino_id",insertable = false,updatable = false)
    private Accounts accounts;


    


}
