package com.acme.sunatapi.repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import com.acme.sunatapi.models.Factura;

public interface FacturaRepository extends JpaRepository<Factura, BigInteger> {

    // Encontrar una factura
    @Query(value = "SELECT o FROM Factura o WHERE o.numeroFactura=?1")
    Optional<Factura> findByNumFactura(BigInteger numeroFactura);

    @Query(value = "SELECT DATE_TRUNC('month', o.fechaEmision) AS fecha_emision_to_month, SUM(o.montoTotal) as montototal FROM Factura o GROUP BY DATE_TRUNC('month', o.fechaEmision)")
    List<Map<String, Object>> querySumaTotalByMonth();

    @Query(value = "SELECT CAST(o.dniReceptor AS text) AS dniReceptor, SUM(o.montoTotal) as montototal FROM Factura o GROUP BY o.dniReceptor")
    List<Map<String, Object>> querySumaTotalByReceptor();

    @Query(value = "SELECT DATE_TRUNC('month', o.fechaEmision) AS fecha_emision_to_month, COUNT(o.idFactura) as facturas FROM Factura o GROUP BY DATE_TRUNC('month', o.fechaEmision)")
    List<Map<String, Object>> querySumaTotalByMonthFacturas();

}