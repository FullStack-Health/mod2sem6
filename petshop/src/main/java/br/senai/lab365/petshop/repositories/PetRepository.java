package br.senai.lab365.petshop.repositories;


import br.senai.lab365.petshop.models.Pet;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PetRepository {

    private static List<Pet> pets;
    private static int ultimoId;

    public List<Pet> listar() {
        return pets;
    }

    public void adicionarPet(Pet pet) {
        pet.setId(++ultimoId);
        pets.add(pet);
    }

    public void removerPet(Pet pet) {
        pets.remove(pet);
    }

    public Pet buscar(int id) {
        return pets.stream().filter(pet -> id == pet.getId()).findFirst().orElse(null);
    }

}
