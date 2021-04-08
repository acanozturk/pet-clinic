package com.practice.petclinic.bootstrap;

import com.practice.petclinic.model.*;
import com.practice.petclinic.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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

        List<PetType> petTypeList = new ArrayList<>();
        List<Owner> ownerList = new ArrayList<>();
        List<Pet> petList = new ArrayList<>();
        List<Speciality> specialityList = new ArrayList<>();
        List<Vet> vetList = new ArrayList<>();
        List<Visit> visitList = new ArrayList<>();

        // Create pet types
        PetType dog = new PetType("dog");
        PetType cat = new PetType("cat");
        PetType owl = new PetType("owl");
        petTypeList.add(dog);
        petTypeList.add(cat);
        petTypeList.add(owl);


        // Create owners
        Owner michaelJordan = new Owner(
                "Michael",
                "Jordan",
                "2300 Sundown Lane",
                "Austin, TX",
                "512-289-6703");
        Owner lionelMessi = new Owner(
                "Lionel",
                "Messi",
                "2244 Eagle Lane",
                "Cross Lake, MN",
                "218-239-9356");
        ownerList.add(michaelJordan);
        ownerList.add(lionelMessi);

        // Create pets
        Pet thunder = new Pet(
                dog,
                "Thunder",
                LocalDate.of(2018, 4, 6),
                michaelJordan);
        Pet daisy = new Pet(
                cat,
                "Daisy",
                LocalDate.of(2019, 7, 20),
                lionelMessi);
        Pet mojito = new Pet(
                owl,
                "Mojito",
                LocalDate.of(2015, 9, 11),
                lionelMessi);
        petList.add(thunder);
        petList.add(daisy);
        petList.add(mojito);
        michaelJordan.getPets().add(thunder);
        lionelMessi.getPets().add(daisy);
        lionelMessi.getPets().add(mojito);

        // Create specialties
        Speciality dentistry = new Speciality("Dentistry");
        Speciality radiology = new Speciality("Radiology");
        Speciality surgery = new Speciality("Surgery");
        specialityList.add(dentistry);
        specialityList.add(radiology);
        specialityList.add(surgery);
        // Create vets
        Vet vetBobby = new Vet(
                "Bobby",
                "Williams",
                "3758 Crosswind Drive",
                "Louisville, KY",
                "502-912-7402",
                Set.of(dentistry, radiology));
        Vet vetLauren = new Vet(
                "Lauren",
                "Higgins",
                "2332 Murry Street",
                "Virginia Beach, VA",
                "757-420-8680",
                Set.of(surgery));
        vetList.add(vetBobby);
        vetList.add(vetLauren);

        // Create visits
        Visit thunderVisit = new Visit(
                LocalDate.of(2020, 4, 14),
                "Annual check-up",
                thunder);
        visitList.add(thunderVisit);
        Visit mojitoVisit = new Visit(
                LocalDate.of(2020, 5, 8),
                "Vaccination",
                mojito);
        visitList.add(thunderVisit);
        visitList.add(mojitoVisit);
        thunder.getVisits().add(thunderVisit);
        mojito.getVisits().add(mojitoVisit);

        // Save objects to services
        petTypeList.forEach(petTypeService::save);
        ownerList.forEach(ownerService::save);
        petList.forEach(petService::save);
        specialityList.forEach(specialityService::save);
        vetList.forEach(vetService::save);
        visitList.forEach(visitService::save);

    }

}
