package com.practice.petclinic.services.map;

import com.practice.petclinic.model.Speciality;
import com.practice.petclinic.services.SpecialityService;

import java.util.Set;

public class SpecialityMapService extends AbstractMapService<Speciality> implements SpecialityService {

    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Speciality speciality) {
        super.delete(speciality);
    }

    @Override
    public Speciality save(Speciality speciality) {
        return super.save(speciality);
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }
}
