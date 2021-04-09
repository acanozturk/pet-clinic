package com.practice.petclinic.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "visit")
@Getter
@Setter
@NoArgsConstructor
public class Visit extends BaseEntity {

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    public Visit(LocalDate date, String description, Pet pet) {
        this.date = date;
        this.description = description;
        this.pet = pet;
    }
}
