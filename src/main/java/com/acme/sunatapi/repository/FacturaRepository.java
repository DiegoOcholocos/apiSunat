package com.acme.sunatapi.repository;

import java.math.BigInteger;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import com.acme.sunatapi.models.Factura;

public interface FacturaRepository extends JpaRepository<Factura, BigInteger> {
    
    // Encontrar una factura
    @Query(value = "SELECT o FROM Factura o WHERE o.numeroFactura=?1")
    Optional<Factura> findByNumFactura(BigInteger numeroFactura);

}