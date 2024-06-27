package ar.edu.davinci.parcial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ar.edu.davinci.parcial.model.*;
import ar.edu.davinci.parcial.repository.*;

@RestController
@RequestMapping("/api/pokemones")
public class PokemonController {

    @Autowired
    private PokemonRepository pokemonRepository;

    @GetMapping("/{id}")
    public ResponseEntity<?> getPokemonById(@PathVariable Long id) {
        Pokemon pokemon = pokemonRepository.findById(id).orElse(null);
        if (pokemon != null) {
            return ResponseEntity.ok(pokemon);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

