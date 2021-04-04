package com.practice.petclinic.bootstrap;

import com.practice.petclinic.model.Owner;
import com.practice.petclinic.model.Pet;
import com.practice.petclinic.model.PetType;
import com.practice.petclinic.model.Vet;
import com.practice.petclinic.services.OwnerService;
import com.practice.petclinic.services.PetService;
import com.practice.petclinic.services.PetTypeService;
import com.practice.petclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final PetService petService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, PetService petService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setBreed("dog");
        petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setBreed("cat");
        petTypeService.save(cat);

        Owner michaelJordan = new Owner();
        michaelJordan.setFirstName("Michael");
        michaelJordan.setLastName("Jordan");
        michaelJordan.setCity("Austin, TX");
        michaelJordan.setAddress("2300 Sundown Lane");
        michaelJordan.setPhoneNumber("512-289-6703");
        ownerService.save(michaelJordan);

        Pet thunder = new Pet();
        thunder.setName("Thunder");
        thunder.setPetType(dog);
        thunder.setBirthDate(LocalDate.of(2018, 4, 6));
        thunder.setOwner(michaelJordan);
        michaelJordan.getPets().add(thunder);

        Owner lionelMessi = new Owner();
        lionelMessi.setFirstName("Lionel");
        lionelMessi.setLastName("Messi");
        lionelMessi.setCity("Cross Lake, MN");
        lionelMessi.setAddress("2244 Eagle Lane");
        lionelMessi.setPhoneNumber("218-239-9356");
        ownerService.save(lionelMessi);

        Pet daisy = new Pet();
        daisy.setName("Daisy");
        daisy.setPetType(cat);
        daisy.setBirthDate(LocalDate.of(2019, 7, 20));
        daisy.setOwner(lionelMessi);
        lionelMessi.getPets().add(daisy);

        Vet vet1 = new Vet();
        vet1.setFirstName("Bobby");
        vet1.setLastName("Williams");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Lauren");
        vet2.setLastName("Higgins");
        vetService.save(vet2);

        System.out.println("Bootstrap is loaded.");
    }
}
