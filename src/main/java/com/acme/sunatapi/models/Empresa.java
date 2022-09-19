package com.acme.sunatapi.models;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import lombok.*;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.format.annotation.DateTimeFormat;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "t_empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; 
    private BigInteger ruc;
    private String razonSocial;
    private String direccion;

    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date fechaInscripcion;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "detalleImpuesto_id")
    private DetalleImpuesto detalleImpuestoId;

    @Transient
    @OneToMany(fetch = FetchType.LAZY)
    private List<Persona> persona;



}