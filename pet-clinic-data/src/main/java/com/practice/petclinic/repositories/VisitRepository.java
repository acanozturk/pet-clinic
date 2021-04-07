package com.practice.petclinic.repositories;

import com.practice.petclinic.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends JpaRepository<Visit, Long> {

}
