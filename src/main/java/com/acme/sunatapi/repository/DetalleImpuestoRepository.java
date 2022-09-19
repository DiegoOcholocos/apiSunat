package com.acme.sunatapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.acme.sunatapi.models.DetalleImpuesto;
import com.acme.sunatapi.models.Empresa;

@Repository
public interface DetalleImpuestoRepository extends JpaRepository<DetalleImpuesto, Integer> {
    @Query(value = "SELECT o FROM DetalleImpuesto o WHERE o.empresa=?1")
    List<DetalleImpuesto> findItemsByEmpresa(Empresa empresa);

}