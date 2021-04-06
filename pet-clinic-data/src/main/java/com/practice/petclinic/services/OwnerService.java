package com.practice.petclinic.services;

import com.practice.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner> {

    Owner findByLastName(String lastName);

}
