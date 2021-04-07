package com.practice.petclinic.repositories;

import com.practice.petclinic.model.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends JpaRepository<Speciality, Long> {

}
