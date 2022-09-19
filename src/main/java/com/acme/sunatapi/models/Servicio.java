package com.acme.sunatapi.models;


import lombok.*;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;



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

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="empresa_id")
    private Empresa empresa;





}