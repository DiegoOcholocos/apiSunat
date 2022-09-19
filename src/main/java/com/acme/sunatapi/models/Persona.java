package com.acme.sunatapi.models;


import java.math.BigInteger;
import java.util.Date;
import lombok.*;
import javax.persistence.*;



import org.springframework.format.annotation.DateTimeFormat;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "t_persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private BigInteger dni;
    private String nombres;
    private String apellidos;
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date fechaNac;
    private String direccion;


}