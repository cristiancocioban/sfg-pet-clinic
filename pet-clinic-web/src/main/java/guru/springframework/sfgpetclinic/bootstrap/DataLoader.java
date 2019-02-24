package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetService petService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetService petService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Cristian");
        owner1.setLastName("Cocioban");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Diana");
        owner2.setLastName("Cocioban");
        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setFirstName("Lavinia");
        vet1.setLastName("Veterinar");
        vetService.save(vet1);

        PetType petType = new PetType();
        petType.setName("dog");

        Pet pet1 = new Pet();
        pet1.setName("Alma");
        pet1.setBirthDate(LocalDate.of(2012, 3, 1));
        pet1.setOwner(owner1);
        pet1.setPetType(petType);
        petService.save(pet1);

        Pet pet2 = new Pet();
        pet2.setName("Igor");
        pet2.setBirthDate(LocalDate.of(2014, 3, 1));
        pet2.setOwner(owner2);
        pet2.setPetType(petType);
        petService.save(pet2);
    }
}
