package com.ejercicio6.jpa.controllers;

import com.ejercicio6.jpa.model.Rol;
import com.ejercicio6.jpa.model.Usuario;
import com.ejercicio6.jpa.model.UsuarioRol;
import com.ejercicio6.jpa.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UsuarioController(UsuarioService usuarioService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usuarioService = usuarioService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @PostMapping("/")
    public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario) throws Exception {
        usuario.setPerfil("default.png");
        usuario.setPassword(this.bCryptPasswordEncoder.encode(usuario.getPassword()));
        Set<UsuarioRol> usuarioRoles = new HashSet<>();

        Rol rol = new Rol();
        rol.setId(2L);
        rol.setNombre("NORMAL");

        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setUsuario(usuario);
        usuarioRol.setRol(rol);
        usuarioRoles.add(usuarioRol);

        return ResponseEntity.ok(usuarioService.guardarUsuario(usuario, usuarioRoles));
    }

    @GetMapping("/{username}")
    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable("username") String username) {
        return ResponseEntity.ok(usuarioService.obtenerUsuario(username));
    }

    @DeleteMapping("/{usuarioId}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable("usuarioId") Long usuarioId) {
        usuarioService.eliminarUsuario(usuarioId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/todos/")
    public ResponseEntity<Set<Usuario>> obtenerUsuarios() {
        return ResponseEntity.ok(new HashSet<>(usuarioService.obtenerUsuarios()));
    }

    @PutMapping("/actualizar/")
    public ResponseEntity<Usuario> actualizarUsuario(@RequestBody Usuario usuario) throws Exception {
        usuario.setPerfil("default.png");
        usuario.setPassword(this.bCryptPasswordEncoder.encode(usuario.getPassword()));
        return ResponseEntity.ok(usuarioService.actualizarUsuario(usuario));

    }

    @GetMapping("/id/{usuarioId}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable("usuarioId") Long usuarioId) {
        return ResponseEntity.ok(usuarioService.obtenerUsuarioPorId(usuarioId));
    }

    // Ejemplo de como actualizar un parametro de un usuario sin borrar los anteriores
    @PutMapping("/contrasena")
    public ResponseEntity<Usuario> actualizarContrasena(@RequestBody Usuario usuario) throws Exception {
        Usuario usuarioActual = usuarioService.obtenerUsuarioPorId(usuario.getId());
        usuarioActual.setPassword(this.bCryptPasswordEncoder.encode(usuario.getPassword()));
        return ResponseEntity.ok(usuarioService.actualizarContrasena(usuarioActual));
    }

}