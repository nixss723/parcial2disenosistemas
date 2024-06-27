package ar.edu.davinci.parcial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.davinci.parcial.model.Pokemon;

import java.util.List;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    List<Pokemon> findByPoderBetween(int poderMinimo, int poderMaximo);
}
