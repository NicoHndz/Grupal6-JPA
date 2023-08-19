package com.ejercicio6.jpa.controllers;

import com.ejercicio6.jpa.model.Rol;
import com.ejercicio6.jpa.services.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rol")
@CrossOrigin("*")
public class RolController {

    private final RolService rolService;

    @Autowired
    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @PostMapping("/")
    public ResponseEntity<Rol> guardarRol(@RequestBody Rol rol) throws Exception {
        return ResponseEntity.ok(rolService.agrergarRol(rol));
    }

    @PutMapping("/")
    public ResponseEntity<Rol> actualizarRol(@RequestBody Rol rol) throws Exception {
        return ResponseEntity.ok(rolService.actualizarRol(rol));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarRol(@PathVariable("id") Long id) {
        ResponseEntity<String> responseEntity = null;
        try {
            rolService.eliminarRol(id);
            responseEntity = ResponseEntity.ok("Rol eliminado correctamente");
        } catch (Exception e) {
            responseEntity = ResponseEntity.ok("Error al eliminar el rol");
        } catch (Throwable throwable) {
            responseEntity = ResponseEntity.ok("Error al eliminar el rol");
        }
        return ResponseEntity.ok(responseEntity);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rol> obtenerRolPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(rolService.obtenerRolPorId(id));
    }

    @GetMapping("/todos/")
    public ResponseEntity<?> obtenerRoles() {

        return ResponseEntity.ok(rolService.obtenerRoless());
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<Rol> obtenerRolPorNombre(@PathVariable("nombre") String nombre) {
        return ResponseEntity.ok(rolService.obtenerRolPorNombre(nombre));
    }

}
