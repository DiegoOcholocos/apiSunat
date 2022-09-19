package com.acme.sunatapi.models;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import lombok.*;
import javax.persistence.*;

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
    private int idFactura;
    private BigInteger numeroFactura;
    private BigInteger numRUCEmisor;
    private int dniReceptor;
    private Date fechaEmision;
    private BigDecimal montoTotal;
}