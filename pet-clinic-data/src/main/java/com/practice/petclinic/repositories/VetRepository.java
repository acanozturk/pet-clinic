package com.practice.petclinic.repositories;

import com.practice.petclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {

}
