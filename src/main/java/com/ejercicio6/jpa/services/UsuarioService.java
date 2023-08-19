package com.ejercicio6.jpa.services;

import com.ejercicio6.jpa.model.Usuario;
import com.ejercicio6.jpa.model.UsuarioRol;

import java.util.Set;

public interface UsuarioService {

    Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception;

    Usuario obtenerUsuario(String username);

    void eliminarUsuario(Long usuarioId);

    //listar todos los usuarios
    Set<Usuario> obtenerUsuarios();

    Usuario actualizarUsuario(Usuario usuario) throws Exception;

    Usuario obtenerUsuarioPorId(Long usuarioId);

    Usuario actualizarContrasena(Usuario usuario) throws Exception;

}