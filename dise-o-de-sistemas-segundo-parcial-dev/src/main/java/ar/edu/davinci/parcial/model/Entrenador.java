package ar.edu.davinci.parcial.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Entity
public class Entrenador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String fechaNacimiento;
    private String nacionalidad;
    private String genero;
    private int edad;

    @OneToMany(mappedBy = "entrenador", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Pokemon> pokemons = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public void capturarPokemon(Pokemon pokemon) {
        if (pokemons.size() < 5) {
            pokemons.add(pokemon);
            pokemon.setEntrenador(this);
        } else {
            throw new RuntimeException("No podes mas de 5 pokemons");
        }
    }

    public void enfrentarseA(Entrenador otroEntrenador) {
        Random random = new Random();
        
        Pokemon miPokemon = this.getPokemons().get(random.nextInt(this.getPokemons().size()));
        Pokemon otroPokemon = otroEntrenador.getPokemons().get(random.nextInt(otroEntrenador.getPokemons().size()));
        
        miPokemon.atacar(otroPokemon);
        otroPokemon.atacar(miPokemon);
    }

}
