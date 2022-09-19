package com.acme.sunatapi.models;
import java.math.BigDecimal;
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
@Table(name = "t_orden")

public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int meses;
    private BigDecimal subtotal;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="factura_id")
    private Factura factura;


    @Transient
    @OneToMany(fetch = FetchType.LAZY)
    private List<Empresa> empresa;
    


}