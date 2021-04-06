package com.practice.petclinic.services.map;

import com.practice.petclinic.model.PetType;
import com.practice.petclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetTypeMapService extends AbstractMapService<PetType> implements PetTypeService {

}
