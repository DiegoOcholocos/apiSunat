package com.acme.sunatapi.repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import com.acme.sunatapi.models.Factura;
import com.acme.sunatapi.models.Persona;

public interface FacturaRepository extends JpaRepository<Factura, BigInteger> {
    
    // Encontrar una factura
    @Query(value = "SELECT o FROM Factura o WHERE o.codigoFactura=?1")
    Optional<Factura> findByCodigo(BigInteger codigoFactura);

    @Query(value = "SELECT o FROM Factura o WHERE o.persona=?1")
    List<Factura> findFacturasByPersona(Persona persona);
}