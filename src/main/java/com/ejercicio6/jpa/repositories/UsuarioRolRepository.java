package com.ejercicio6.jpa.repositories;

import com.ejercicio6.jpa.model.Rol;
import com.ejercicio6.jpa.model.Usuario;
import com.ejercicio6.jpa.model.UsuarioRol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface UsuarioRolRepository extends JpaRepository<UsuarioRol, Long> {

    List<UsuarioRol> findByUsuario(Usuario usuario);

    List<UsuarioRol> findByRol(Rol rol);


}
