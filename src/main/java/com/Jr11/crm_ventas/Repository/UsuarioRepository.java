package com.Jr11.crm_ventas.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Jr11.crm_ventas.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

}
