package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.services.PetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetServiceMap extends MapService<Pet, Long> implements PetService {
    @Override
    public Pet findByName(String name) {
        Set<Pet> pets = super.findAll();
        for(Pet pet: pets) {
            if(name == pet.getName()) return pet;
        }

        return null;
    }
}
