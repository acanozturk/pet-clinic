package com.practice.petclinic.repositories;

import com.practice.petclinic.model.PetType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends JpaRepository<PetType, Long> {

}
