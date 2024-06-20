package br.senai.lab365.petshop.controllers;

import br.senai.lab365.petshop.models.Pet;
import br.senai.lab365.petshop.services.PetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/pets")
public class PetController {

    private PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping
    public void cadastra(Pet pet) {
        petService.cadastrar(pet);
    }

    @GetMapping
    public List<Pet> busca() {
        return petService.listar();
    }

    @GetMapping("/{id}")
    public Pet busca(@PathVariable int id) {
        // TODO: busca pet específico

        return pet;
    }
}
