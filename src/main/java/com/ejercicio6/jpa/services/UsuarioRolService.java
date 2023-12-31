package com.ejercicio6.jpa.services;


import com.ejercicio6.jpa.model.UsuarioRol;

import java.util.List;

public interface UsuarioRolService {

    UsuarioRol guardarUsuarioRol(UsuarioRol usuarioRol) throws Exception;

    List<UsuarioRol> obtenerUsuarioRolUsuario(Long usuarioId);

    void eliminarUsuarioRol(Long usuarioRolId);

    List<UsuarioRol> obtenerUsuarioRol();

    List<UsuarioRol> obtenerUsuarioRolRol(Long rolId);

    UsuarioRol actualizarUsuarioRol(UsuarioRol usuarioRol) throws Exception;

}
