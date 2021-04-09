package com.practice.petclinic.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pet_types")
@Getter
@Setter
@NoArgsConstructor
public class PetType extends BaseEntity {

    @Column(name = "breed")
    private String breed;

    public PetType(String breed) {
        this.breed = breed;
    }

    @Override
    public String toString() {
        return breed;
    }
}
