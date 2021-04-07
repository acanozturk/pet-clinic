package com.practice.petclinic.services.map;

import com.practice.petclinic.model.Pet;
import com.practice.petclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class PetMapService extends AbstractMapService<Pet> implements PetService {

}