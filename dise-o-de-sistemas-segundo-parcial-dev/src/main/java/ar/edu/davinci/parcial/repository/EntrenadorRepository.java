package ar.edu.davinci.parcial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.davinci.parcial.model.Entrenador;

import java.util.List;

@Repository
public interface EntrenadorRepository extends JpaRepository<Entrenador, Long> {
    List<Entrenador> findByNombreContainingIgnoreCase(String nombre);
}
