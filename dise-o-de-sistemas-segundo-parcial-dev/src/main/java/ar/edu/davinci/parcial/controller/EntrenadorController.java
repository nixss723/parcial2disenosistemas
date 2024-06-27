package ar.edu.davinci.parcial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ar.edu.davinci.parcial.model.*;
import ar.edu.davinci.parcial.service.*;

@RestController
@RequestMapping("/api/entrenadores")
public class EntrenadorController {

    @Autowired
    private EntrenadorService entrenadorService;

    @PostMapping("/crear")
    public ResponseEntity<Entrenador> crearEntrenador(@RequestBody Entrenador entrenador) {
        Entrenador nuevoEntrenador = entrenadorService.crearEntrenador(entrenador);
        return ResponseEntity.ok(nuevoEntrenador);
    }

    @PostMapping("/{id1}/luchar/{id2}")
    public ResponseEntity<?> luchar(@PathVariable Long id1, @PathVariable Long id2) {
        try {
            entrenadorService.luchar(id1, id2);
            return ResponseEntity.ok("Lucha realizada entre los entrenadores con ID " + id1 + " y " + id2);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}

