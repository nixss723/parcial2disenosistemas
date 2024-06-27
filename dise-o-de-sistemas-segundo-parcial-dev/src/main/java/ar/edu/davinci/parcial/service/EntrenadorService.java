package ar.edu.davinci.parcial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.davinci.parcial.model.Entrenador;
import ar.edu.davinci.parcial.repository.EntrenadorRepository;

import java.util.Optional;

@Service
public class EntrenadorService {

    @Autowired
    private EntrenadorRepository entrenadorRepository;

    public Entrenador crearEntrenador(Entrenador entrenador) {
        return entrenadorRepository.save(entrenador);
    }

    public void luchar(Long idEntrenador1, Long idEntrenador2) {
        Optional<Entrenador> optionalEntrenador1 = entrenadorRepository.findById(idEntrenador1);
        Optional<Entrenador> optionalEntrenador2 = entrenadorRepository.findById(idEntrenador2);

        if (optionalEntrenador1.isPresent() && optionalEntrenador2.isPresent()) {
            Entrenador entrenador1 = optionalEntrenador1.get();
            Entrenador entrenador2 = optionalEntrenador2.get();

            entrenador1.enfrentarseA(entrenador2);
            entrenador2.enfrentarseA(entrenador1);

            entrenadorRepository.save(entrenador1);
            entrenadorRepository.save(entrenador2);
        } else {
            throw new RuntimeException("No se encontradon entrenadores con los IDs proporcionads");
        }
    }

}

