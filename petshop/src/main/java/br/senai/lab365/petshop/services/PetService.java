package br.senai.lab365.petshop.services;


import br.senai.lab365.petshop.models.Pet;
import br.senai.lab365.petshop.repositories.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    private PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }


    public void cadastrar(Pet pet) {
        petRepository.adicionarPet(pet);
    }

    public List<Pet> listar() {
        return petRepository.listar();
    }
}
