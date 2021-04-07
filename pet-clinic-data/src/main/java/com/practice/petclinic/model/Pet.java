package com.practice.petclinic.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pets")
@Getter
@Setter
@NoArgsConstructor
public class Pet extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "pet_type_id")
    private PetType petType;

    @Column(name = "pet_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>();

    public Pet(PetType petType, String name, LocalDate birthDate, Owner owner) {
        this.petType = petType;
        this.name = name;
        this.birthDate = birthDate;
        this.owner = owner;
    }

}
