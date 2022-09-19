package com.acme.sunatapi.models;

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
@Table(name = "t_servicio")
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; 
    private String nombreServicio;
    private String descripcionServicio;
    private float precio;

    /* @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="orden_id")
    private Orden orden;*/

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="empresa_id")
    private Empresa empresa;





}