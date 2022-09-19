package com.acme.sunatapi.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.acme.sunatapi.models.Empresa;
import com.acme.sunatapi.models.Orden;
import com.acme.sunatapi.models.Servicio;


@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Integer>  {
    @Query(value = "SELECT o FROM Servicio o WHERE o.empresa=?1")
    List<Servicio> findServiciosByEmpresa(Empresa empresa);
}