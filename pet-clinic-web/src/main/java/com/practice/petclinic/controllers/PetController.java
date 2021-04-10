package com.practice.petclinic.controllers;

import com.practice.petclinic.model.Owner;
import com.practice.petclinic.model.PetType;
import com.practice.petclinic.services.OwnerService;
import com.practice.petclinic.services.PetService;
import com.practice.petclinic.services.PetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@RequestMapping("/owners/{ownerId}")
@Controller
public class PetController {

    private final OwnerService ownerService;
    private final PetService petService;
    private final PetTypeService petTypeService;
    private static final String VIEW_PET_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm";

    @Autowired
    public PetController(OwnerService ownerService, PetService petService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder webDataBinder) {
        webDataBinder.setDisallowedFields("id");
    }

    @ModelAttribute("types")
    public Collection<PetType> findPetTypes() {
        return petTypeService.findAll();
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable("ownerId") Long ownerId) {
        return ownerService.findById(ownerId);
    }


}
