package ar.edu.davinci.parcial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.davinci.parcial.model.Pokemon;
import ar.edu.davinci.parcial.repository.PokemonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    public Pokemon guardarPokemon(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

    public Optional<Pokemon> buscarPorId(Long id) {
        return pokemonRepository.findById(id);
    }

    public List<Pokemon> buscarPorRangoDePoder(int poderMinimo, int poderMaximo) {
        return pokemonRepository.findByPoderBetween(poderMinimo, poderMaximo);
    }

}
