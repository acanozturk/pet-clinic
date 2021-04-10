package com.practice.petclinic.repositories;

import com.practice.petclinic.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
    Pet findByNameContainingIgnoreCase(String name);
}
