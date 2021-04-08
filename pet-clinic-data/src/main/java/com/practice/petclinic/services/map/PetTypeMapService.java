package com.practice.petclinic.services.map;

import com.practice.petclinic.model.PetType;
import com.practice.petclinic.services.PetTypeService;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
@NoArgsConstructor
public class PetTypeMapService extends AbstractMapService<PetType> implements PetTypeService {

}
