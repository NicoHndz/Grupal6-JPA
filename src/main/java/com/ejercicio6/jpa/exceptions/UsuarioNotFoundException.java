package com.ejercicio6.jpa.exceptions;

public class UsuarioNotFoundException extends Exception{
    public UsuarioNotFoundException(){
        super("El usuario no existe en la Base de datos");
    }

    public UsuarioNotFoundException(String mensaje){
        super(mensaje);
    }
}
