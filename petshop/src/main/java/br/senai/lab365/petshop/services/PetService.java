package br.senai.lab365.petshop.services;

import br.senai.lab365.petshop.models.Pet;
import br.senai.lab365.petshop.repositories.PetRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PetService {

  private final PetRepository petRepository;

  public PetService(PetRepository petRepository) {
    this.petRepository = petRepository;
  }

  public void cadastrar(Pet pet) {
    petRepository.adicionarPet(pet);
  }

  public List<Pet> listar() {
    return petRepository.listar();
  }

  public Pet buscar(int id) {
    return petRepository.buscar(id);
  }

  public boolean excluir(int id) {
    var petExcluir = petRepository.buscar(id);
    if (petExcluir != null) {
      petRepository.removerPet(petExcluir);
      return true;
    }
    return false;
  }

  public boolean atualizar(Pet pet) {
    var petAtualizar = petRepository.buscar(pet.getId());
    if (petAtualizar != null) {
      petAtualizar.setNome(pet.getNome());
      petAtualizar.setRaca(pet.getRaca());
      petAtualizar.setEspecie(pet.getEspecie());
      atualizarHistoricoPeso(petAtualizar, pet.getPeso());
      petAtualizar.setPeso(pet.getPeso());
      petAtualizar.setAltura(pet.getAltura());
      petAtualizar.setDataNascimento(pet.getDataNascimento());
      return true;
    }

    return false;
  }

  private void atualizarHistoricoPeso(Pet pet, double peso) {
    pet.getHistoricoPeso().put(LocalDate.now(), peso);
  }
}
