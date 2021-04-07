package com.practice.petclinic.services.jpa;

import com.practice.petclinic.model.Visit;
import com.practice.petclinic.repositories.VisitRepository;
import com.practice.petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("map")
public class VisitJpaService extends AbstractJpaService<Visit, VisitRepository> implements VisitService {

    public VisitJpaService(VisitRepository repository) {
        super(repository);
    }
}
