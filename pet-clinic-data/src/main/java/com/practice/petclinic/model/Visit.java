package com.practice.petclinic.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "visit")
@Getter
@Setter
@NoArgsConstructor
public class Visit extends BaseEntity {

    @Column(name = "date")
    @DateTimeFormat(pattern="yyyy-MM-dd")
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
