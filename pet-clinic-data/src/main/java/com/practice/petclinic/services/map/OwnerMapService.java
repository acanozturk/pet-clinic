package com.practice.petclinic.services.map;

import com.practice.petclinic.model.Owner;
import com.practice.petclinic.services.OwnerService;
import org.springframework.stereotype.Service;

@Service
public class OwnerMapService extends AbstractMapService<Owner> implements OwnerService {

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
