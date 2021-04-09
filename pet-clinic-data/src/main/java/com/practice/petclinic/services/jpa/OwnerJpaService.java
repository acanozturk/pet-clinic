package com.practice.petclinic.services.jpa;

import com.practice.petclinic.model.Owner;
import com.practice.petclinic.repositories.OwnerRepository;
import com.practice.petclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@Profile("jpa")
public class OwnerJpaService extends AbstractJpaService<Owner, OwnerRepository> implements OwnerService {

    public OwnerJpaService(OwnerRepository repository) {
        super(repository);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return repository.findByLastName(lastName);
    }

    @Override
    public List<Owner> findByLastNameContainingIgnoreCase(String lastName) {
        return repository.findByLastNameContainingIgnoreCase(lastName);
    }
}
