package com.acme.sunatapi.models;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import lombok.*;
import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Impuestos {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private BigInteger codImpuesto;
    private String descripcionImpuesto;
    private BigDecimal importe;

    @Transient
    @OneToMany(fetch = FetchType.LAZY)
    private List<DetalleImpuesto> detalleImpuesto;

}