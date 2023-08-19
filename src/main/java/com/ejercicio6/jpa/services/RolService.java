package com.ejercicio6.jpa.services;

import com.ejercicio6.jpa.model.Rol;

import java.util.List;

public interface RolService {

    Rol agrergarRol(Rol rol) throws Exception;

    Rol obtenerRolPorId(Long id);

    void eliminarRol(Long id);

    Rol actualizarRol(Rol rol) throws Exception;

    List<Rol> obtenerRoless();

    Rol obtenerRolPorNombre(String nombre);


}
