package com.apibanco.bancoapi.model.entity;

import java.io.Serializable;
import java.util.List;

import com.apibanco.bancoapi.model.User.User;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "cuentas")
public class Cuenta implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "usuario_id")
    private Integer usuarioId;

    @Column(name = "numero_cuenta")
    private Integer numeroCuenta;

    @Column(name = "saldo")
    private double saldo;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "usuario_id", insertable = false, updatable = false, nullable = false)
    private User usuarios;


    @OneToMany(mappedBy = "cuenta")
    private List<Transacciones>transactions;

    
}
