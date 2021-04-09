package com.practice.petclinic.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vets")
@Getter
@Setter
@NoArgsConstructor
public class Vet extends Person {

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialities",
            joinColumns = @JoinColumn(name = "vet_id"),
            inverseJoinColumns = @JoinColumn(name = "specialty_id"))
    private Set<Speciality> specialities = new HashSet<>();

    public Vet(String firstName,
               String lastName,
               String address,
               String city,
               String phoneNumber,
               Set<Speciality> specialities) {
        super(firstName, lastName, address, city, phoneNumber);
        this.specialities = specialities;
    }
}
