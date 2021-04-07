package com.practice.petclinic.repositories;

import com.practice.petclinic.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {

}
