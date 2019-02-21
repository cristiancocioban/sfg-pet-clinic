package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long Id);
    Pet findByName(String name);
    Pet save(Pet pet);
    Set<Pet> findAll();
}
