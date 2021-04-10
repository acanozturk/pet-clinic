package com.practice.petclinic.repositories;

import com.practice.petclinic.model.PetType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetTypeRepository extends JpaRepository<PetType, Long> {

}
