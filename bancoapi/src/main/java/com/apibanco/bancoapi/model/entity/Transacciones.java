package com.apibanco.bancoapi.model.entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "transacciones")
public class Transacciones {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

  @Column(name = "cuenta_origen_id")
    private Integer cuentaOrigenId;


    @Column(name = "cuenta_destino_id")
    private Integer cuentaDestinoId;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "monto")
    private double monto;

    @Column(name = "descripcion")
    private String descripcion;


    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "cuenta_origen_id",insertable = false,updatable = false,nullable = false)
    private Cuenta cuenta;



}
