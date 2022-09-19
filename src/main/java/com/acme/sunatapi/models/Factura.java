package com.acme.sunatapi.models;
import java.math.BigInteger;
import java.util.Date;
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
@Table(name = "t_factura")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private BigInteger codigoFactura;
    private Date fechaEmision;
    private float igv;
    private float totalImpuesto;
    private float total;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="persona_id")
    private Persona persona;


    @Transient
    @OneToMany(fetch = FetchType.LAZY)
    private List<Orden> orden;



}