package com.acme.sunatapi.models;
import java.math.BigInteger;
import java.util.List;

import lombok.*;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    
    @Transient
    @OneToMany(fetch = FetchType.LAZY)
    private List<Servicio> servicio;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="orden_id")
    private Orden orden;



}