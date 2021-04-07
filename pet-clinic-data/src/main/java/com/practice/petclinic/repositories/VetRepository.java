package com.practice.petclinic.repositories;

import com.practice.petclinic.model.Vet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends JpaRepository<Vet, Long> {

}
