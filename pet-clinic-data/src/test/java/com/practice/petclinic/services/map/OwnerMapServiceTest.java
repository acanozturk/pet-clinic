package com.practice.petclinic.services.map;

import com.practice.petclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    Long id = 1L;

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService();
        Owner testOwner = new Owner(
                "testFirstName",
                "testSecondName",
                "testAddress",
                "testCity",
                "testPhone");
        testOwner.setId(id);
        ownerMapService.save(testOwner);
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();
        assertEquals(1, ownerSet.size());
    }

    @Test
    void findById() {
       Owner findOwner = ownerMapService.findById(id);

       assertEquals(1L, findOwner.getId());
    }

    @Test
    void save() {
        Owner saveOwner = new Owner(
                "savetestFirstName",
                "savetestSecondName",
                "savetestAddress",
                "savetestCity",
                "savetestPhone");
        ownerMapService.save(saveOwner);

        assertEquals("savetestFirstName", saveOwner.getFirstName());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(id);

        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(id));

        assertEquals(0, ownerMapService.findAll().size());

    }

    @Test
    void findByLastName() {
        Owner lastNameOwner = new Owner(
                "lastNameFirstName",
                "lastNameSecondName",
                "lastNameAddress",
                "lastNameCity",
                "lastNamePhone");
        ownerMapService.save(lastNameOwner);

        assertEquals(lastNameOwner, ownerMapService.findByLastName("lastNameSecondName"));
    }
}