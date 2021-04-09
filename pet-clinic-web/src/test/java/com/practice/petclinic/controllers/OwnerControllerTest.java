package com.practice.petclinic.controllers;

import com.practice.petclinic.model.Owner;
import com.practice.petclinic.services.OwnerService;
import org.hamcrest.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.*;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @Mock
    OwnerService ownerService;

    @InjectMocks
    OwnerController ownerController;

    MockMvc mockMvc;

    Set<Owner> owners;

    @BeforeEach
    void setUp() {
        owners = new HashSet<>();
        Owner testOwner1 = new Owner(
                "test1tFirstName",
                "test1SecondName",
                "test1tAddress",
                "test1City",
                "test1Phone");
        testOwner1.setId(1L);
        Owner testOwner2 = new Owner(
                "test2tFirstName",
                "test2SecondName",
                "test2tAddress",
                "test2City",
                "test2Phone");
        testOwner2.setId(2L);
        owners.add(testOwner1);
        owners.add(testOwner2);

        mockMvc = MockMvcBuilders
                .standaloneSetup(ownerController)
                .build();
    }

    @Test
    void listOfOwners() throws Exception {
        mockMvc.perform(get("/owners/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/findOwners"))
                .andExpect(model().attributeExists("owner"));

        verifyNoInteractions(ownerService);
    }

    @Test
    void displayOwner() throws Exception {
        when(ownerService.findById(anyLong()))
                .thenReturn(owners.stream()
                        .filter(owner -> owner.getId().equals(1L))
                        .findFirst()
                        .get());

        mockMvc.perform(get("/owners/132"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/ownerDetails"))
                .andExpect(model().attribute("owner", hasProperty("id", is(1L))));
    }

    @Test
    void ownerFindFormReturnOne() throws Exception {
        when(ownerService.findAllByLastName(anyString()))
                .thenReturn(Arrays.asList(owners.stream()
                        .filter(owner -> owner.getId().equals(1L))
                        .findFirst()
                        .get()));

        mockMvc.perform(get("/owners"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/1"));
    }

    @Test
    void ownerFindFormReturnMany() throws Exception {
        List<Owner> ownerTest = new ArrayList<>();
        ownerTest.addAll(owners);
        when(ownerService.findAllByLastName(anyString()))
                .thenReturn(ownerTest);

        mockMvc.perform(get("/owners"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/ownersList"))
                .andExpect(model().attribute("selections", hasSize(2)));
    }

}