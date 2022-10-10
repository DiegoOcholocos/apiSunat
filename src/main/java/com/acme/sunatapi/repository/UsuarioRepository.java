package com.acme.sunatapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acme.sunatapi.models.Usuario;

@Repository
public interface  UsuarioRepository extends JpaRepository<Usuario, String>{


}