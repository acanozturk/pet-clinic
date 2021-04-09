package com.practice.petclinic.services;

import com.practice.petclinic.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner> {
    Owner findByLastName(String lastName);
    List<Owner> findByLastNameContainingIgnoreCase(String lastName);
}
