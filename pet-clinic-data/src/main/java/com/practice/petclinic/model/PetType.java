package com.practice.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pet_types")
@Getter
@Setter
public class PetType extends BaseEntity {

    @Column(name = "breed")
    private String breed;

}
