package com.practice.petclinic.services;

import com.practice.petclinic.model.BaseEntity;

import java.util.Set;

public interface CrudService<T extends BaseEntity> {

    Set<T> findAll();

    T findById(Long id);

    T save(T object);

    void delete(T object);

    void deleteById(Long id);

}
