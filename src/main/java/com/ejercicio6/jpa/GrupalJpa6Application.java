package com.ejercicio6.jpa;

import com.ejercicio6.jpa.exceptions.UsuarioFoundException;
import com.ejercicio6.jpa.model.Rol;
import com.ejercicio6.jpa.model.Usuario;
import com.ejercicio6.jpa.model.UsuarioRol;
import com.ejercicio6.jpa.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class GrupalJpa6Application implements CommandLineRunner {

/*
	// Insercion de usuarios
	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
*/
	public static void main(String[] args) {
		SpringApplication.run(GrupalJpa6Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Insercion de Usuarios y ROL
		/*
		try {
		Usuario usuario = new Usuario();

		usuario.setUsername("Gian");
		usuario.setPassword(bCryptPasswordEncoder.encode("12345"));
		usuario.setEmail("Gian@gmail.com");
		usuario.setTelefono("123456789");
		usuario.setPerfil("foto.png");

		Usuario usuario2 = new Usuario();
		usuario2.setUsername("Normal");
		usuario2.setPassword(bCryptPasswordEncoder.encode("12345"));
		usuario2.setEmail("Normal@gmail.com");
		usuario2.setTelefono("123456789");
		usuario2.setPerfil("foto.png");

		Rol rol = new Rol();
		rol.setId(1L);
		rol.setNombre("ADMIN");

		Rol rol2 = new Rol();
		rol2.setId(2L);
		rol2.setNombre("NORMAL");

		Set<UsuarioRol> usuarioRoles = new HashSet<>();

		UsuarioRol usuarioRol = new UsuarioRol();

		usuarioRol.setRol(rol);
		usuarioRol.setUsuario(usuario);
		usuarioRoles.add(usuarioRol);
		Usuario usuarioGuardado = usuarioService.guardarUsuario(usuario,
				usuarioRoles);

		Set<UsuarioRol> usuarioRoles2 = new HashSet<>();
		UsuarioRol usuarioRol2 = new UsuarioRol();

		usuarioRol2.setRol(rol2);
		usuarioRol2.setUsuario(usuario2);
		usuarioRoles2.add(usuarioRol2);

		Usuario usuarioGuardado2 = usuarioService.guardarUsuario(usuario2,
				usuarioRoles2);


	} catch(UsuarioFoundException exception) {
		exception.printStackTrace();
	}
		*/

	}
}
