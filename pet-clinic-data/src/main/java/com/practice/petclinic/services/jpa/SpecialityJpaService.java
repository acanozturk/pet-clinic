package com.practice.petclinic.services.jpa;

import com.practice.petclinic.model.Speciality;
import com.practice.petclinic.repositories.SpecialtyRepository;
import com.practice.petclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("jpa")
public class SpecialityJpaService extends AbstractJpaService<Speciality, SpecialtyRepository> implements SpecialityService {

    public SpecialityJpaService(SpecialtyRepository repository) {
        super(repository);
    }
}
