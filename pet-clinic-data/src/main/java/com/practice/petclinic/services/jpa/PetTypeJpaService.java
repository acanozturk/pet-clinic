package com.practice.petclinic.services.jpa;

import com.practice.petclinic.model.PetType;
import com.practice.petclinic.repositories.PetTypeRepository;
import com.practice.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("jpa")
public class PetTypeJpaService extends AbstractJpaService<PetType, PetTypeRepository> implements PetTypeService {

    public PetTypeJpaService(PetTypeRepository repository) {
        super(repository);
    }
}
