package com.practice.petclinic.bootstrap;

import com.practice.petclinic.model.*;
import com.practice.petclinic.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Set;

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
        PetType dog = new PetType("dog");
        petTypeService.save(dog);

        PetType cat = new PetType("cat");
        petTypeService.save(cat);

        Owner michaelJordan = new Owner(
                "Michael",
                "Jordan",
                "2300 Sundown Lane",
                "Austin, TX",
                "512-289-6703");
        ownerService.save(michaelJordan);

        Owner lionelMessi = new Owner(
                "Lionel",
                "Messi",
                "2244 Eagle Lane",
                "Cross Lake, MN",
                "218-239-9356");
        ownerService.save(lionelMessi);

        Pet thunder = new Pet(
                dog,
                "Thunder",
                LocalDate.of(2018, 4, 6)
        );
        petService.save(thunder);
        thunder.setOwner(michaelJordan);
        michaelJordan.getPets().add(thunder);

        Pet daisy = new Pet(
                cat,
                "Daisy",
                LocalDate.of(2019, 7, 20)
        );
        petService.save(daisy);
        daisy.setOwner(lionelMessi);
        lionelMessi.getPets().add(daisy);

        Speciality radiology = new Speciality("Radiology");
        specialityService.save(radiology);

        Speciality surgery = new Speciality("Surgery");
        specialityService.save(surgery);

        Speciality dentistry = new Speciality("Dentistry");
        specialityService.save(dentistry);

        Vet vetBobby = new Vet(
                "Bobby",
                "Williams",
                "3758 Crosswind Drive",
                "Louisville, KY",
                "502-912-7402",
                Set.of(radiology, dentistry)
        );
        vetService.save(vetBobby);

        Vet vetLauren = new Vet(
                "Lauren",
                "Higgins",
                "2332 Murry Street",
                "Virginia Beach, VA",
                "757-420-8680",
                Set.of(radiology, surgery)
        );
        vetService.save(vetLauren);

        Visit thunderVisit = new Visit(
                LocalDate.of(2020, 4, 14),
                "Annual check-up",
                thunder
        );
        thunder.getVisits().add(thunderVisit);
        visitService.save(thunderVisit);

    }
}
