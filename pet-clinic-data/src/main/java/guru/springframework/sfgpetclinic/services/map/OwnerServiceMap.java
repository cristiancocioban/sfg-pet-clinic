package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.OwnerService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class OwnerServiceMap extends MapService<Owner, Long> implements OwnerService {
    @Override
    public Owner findByName(String name) {
        Set<Owner> owners = super.findAll();
        for(Owner owner: owners) {
            if(name == owner.getLastName()) return owner;
        }

        return null;
    }
}
