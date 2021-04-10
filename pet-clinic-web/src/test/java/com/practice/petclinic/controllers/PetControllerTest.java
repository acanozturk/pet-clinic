package com.practice.petclinic.controllers;

import com.practice.petclinic.model.Owner;
import com.practice.petclinic.model.Pet;
import com.practice.petclinic.model.PetType;
import com.practice.petclinic.services.OwnerService;
import com.practice.petclinic.services.PetService;
import com.practice.petclinic.services.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.*;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class PetControllerTest {

    @Mock
    PetService petService;

    @Mock
    OwnerService ownerService;

    @Mock
    PetTypeService petTypeService;

    @InjectMocks
    PetController petController;

    MockMvc mockMvc;
    Owner testOwner;
    Set<PetType> testPetTypes;

    @BeforeEach
    void setUp() {
        testOwner = new Owner(
                "test",
                "test",
                "test",
                "test",
                "test");
        testOwner.setId(1L);

        testPetTypes = new HashSet<>();
        PetType testPetType1 = new PetType("Cat");
        PetType testPetType2 = new PetType("Dog");
        testPetType1.setId(1L);
        testPetType2.setId(2L);
        testPetTypes.add(testPetType1);
        testPetTypes.add(testPetType2);

        mockMvc = MockMvcBuilders
                .standaloneSetup(petController)
                .build();
    }

    @Test
    void initializeCreationForm() throws Exception {
        when(ownerService.findById(anyLong()))
                .thenReturn(testOwner);
        when(petTypeService.findAll())
                .thenReturn(testPetTypes);

        mockMvc.perform(get("/owners/1/pets/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("pets/createOrUpdatePetForm"))
                .andExpect(model().attributeExists("owner"))
                .andExpect(model().attributeExists("pet"));
    }

    @Test
    void processCreationForm() throws Exception {
        when(ownerService.findById(anyLong()))
                .thenReturn(testOwner);
        when(petTypeService.findAll())
                .thenReturn(testPetTypes);

        mockMvc.perform(post("/owners/1/pets/new"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/1"));

        verify(petService).save(any());
    }

    @Test
    void initializeUpdatePetForm() throws Exception {
        Pet testPet = new Pet();
        testPet.setId(1L);

        when(ownerService.findById(anyLong()))
                .thenReturn(testOwner);
        when(petTypeService.findAll())
                .thenReturn(testPetTypes);
        when(petService.findById(anyLong()))
                .thenReturn(testPet);

        mockMvc.perform(get("/owners/1/pets/1/edit"))
                .andExpect(status().isOk())
                .andExpect(view().name("pets/createOrUpdatePetForm"))
                .andExpect(model().attributeExists("owner"))
                .andExpect(model().attributeExists("pet"));
    }

    @Test
    void processUpdatePetForm() throws Exception {
        when(ownerService.findById(anyLong()))
                .thenReturn(testOwner);
        when(petTypeService.findAll())
                .thenReturn(testPetTypes);

        mockMvc.perform(get("/owners/1/pets/1/edit"))
                .andExpect(status().isOk())
                .andExpect(view().name("pets/createOrUpdatePetForm"))
                .andExpect(model().attributeExists("owner"));

    }
}