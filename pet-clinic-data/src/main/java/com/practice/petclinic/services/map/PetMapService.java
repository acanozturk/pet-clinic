package com.practice.petclinic.services.map;

import com.practice.petclinic.model.Pet;
import com.practice.petclinic.services.PetService;
import org.springframework.stereotype.Service;

@Service
public class PetMapService extends AbstractMapService<Pet> implements PetService {

}