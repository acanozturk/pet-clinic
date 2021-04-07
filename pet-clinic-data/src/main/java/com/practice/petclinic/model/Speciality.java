package com.practice.petclinic.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "specialities")
@Getter
@Setter
@NoArgsConstructor
public class Speciality extends BaseEntity {

    @Column(name = "speciality")
    private String speciality;

    public Speciality(String speciality) {
        this.speciality = speciality;
    }
}
