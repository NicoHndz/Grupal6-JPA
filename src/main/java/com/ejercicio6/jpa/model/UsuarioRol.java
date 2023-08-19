package com.ejercicio6.jpa.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "usuario_rol")
public class UsuarioRol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuarioRolId;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    private Rol rol;

    public UsuarioRol() {
    }

}
