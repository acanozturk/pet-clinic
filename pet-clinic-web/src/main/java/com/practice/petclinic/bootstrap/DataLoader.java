package com.practice.petclinic.bootstrap;

import com.practice.petclinic.model.Owner;
import com.practice.petclinic.model.PetType;
import com.practice.petclinic.model.Vet;
import com.practice.petclinic.services.OwnerService;
import com.practice.petclinic.services.PetTypeService;
import com.practice.petclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Doggo");
        petTypeService.save(dog);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Jordan");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Aboubakar");
        owner2.setLastName("Kamara");
        ownerService.save(owner2);

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
