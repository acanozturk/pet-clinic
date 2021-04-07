package com.practice.petclinic.bootstrap;

import com.practice.petclinic.model.*;
import com.practice.petclinic.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component

public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final PetService petService;
    private final PetTypeService petTypeService;
    private final VetService vetService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    @Autowired
    public DataLoader(OwnerService ownerService,
                      PetService petService,
                      PetTypeService petTypeService,
                      VetService vetService,
                      SpecialityService specialityService,
                      VisitService visitService) {
        this.ownerService = ownerService;
        this.petService = petService;
        this.petTypeService = petTypeService;
        this.vetService = vetService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        loadData();
        System.out.println("Bootstrap is loaded.");
    }

    private void loadData() {
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
        petService.save(thunder);
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
        petService.save(daisy);
        lionelMessi.getPets().add(daisy);

        Speciality radiology = new Speciality();
        radiology.setSpeciality("Radiology");
        specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setSpeciality("Surgery");
        specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setSpeciality("Dentistry");
        specialityService.save(dentistry);

        Vet vet1 = new Vet();
        vet1.setFirstName("Bobby");
        vet1.setLastName("Williams");
        vet1.getSpecialities().add(surgery);
        vet1.getSpecialities().add(radiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Lauren");
        vet2.setLastName("Higgins");
        vet2.getSpecialities().add(radiology);
        vet2.getSpecialities().add(dentistry);
        vetService.save(vet2);

        Visit thunderVisit = new Visit();
        thunderVisit.setPet(thunder);
        thunderVisit.setDate(LocalDate.of(2020, 4, 14));
        thunderVisit.setDescription("Annual check-up");
        thunder.getVisits().add(thunderVisit);
        visitService.save(thunderVisit);

    }
}
