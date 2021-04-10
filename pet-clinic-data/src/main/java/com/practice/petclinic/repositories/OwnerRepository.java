package com.practice.petclinic.repositories;

import com.practice.petclinic.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
    Owner findByLastName(String lastName);
    List<Owner> findByLastNameContainingIgnoreCase(String lastName);
}
