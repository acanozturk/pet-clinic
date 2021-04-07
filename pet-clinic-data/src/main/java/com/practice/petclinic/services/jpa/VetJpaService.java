package com.practice.petclinic.services.jpa;

import com.practice.petclinic.model.Vet;
import com.practice.petclinic.repositories.VetRepository;
import com.practice.petclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("jpa")
public class VetJpaService extends AbstractJpaService<Vet, VetRepository> implements VetService {

    public VetJpaService(VetRepository repository) {
        super(repository);
    }
}
