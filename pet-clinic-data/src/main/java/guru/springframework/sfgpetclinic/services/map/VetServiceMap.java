package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends MapService<Vet, Long> implements VetService {
    @Override
    public Vet findByName(String name) {
        Set<Vet> vets = super.findAll();
        for(Vet vet: vets) {
            if(name == vet.getLastName()) return vet;
        }

        return null;
    }
}
