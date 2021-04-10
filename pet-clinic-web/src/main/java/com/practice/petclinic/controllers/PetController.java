package com.practice.petclinic.controllers;

import com.practice.petclinic.model.Owner;
import com.practice.petclinic.model.Pet;
import com.practice.petclinic.model.PetType;
import com.practice.petclinic.services.OwnerService;
import com.practice.petclinic.services.PetService;
import com.practice.petclinic.services.PetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

import static org.springframework.util.StringUtils.hasLength;

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

    @ModelAttribute("pet_types")
    public Collection<PetType> findPetTypes() {
        return petTypeService.findAll();
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable("ownerId") Long ownerId) {
        return ownerService.findById(ownerId);
    }

    @GetMapping("/pets/new")
    public String initializeCreationForm(Owner owner, Model model) {
        Pet pet = new Pet();
        owner.getPets().add(pet);
        pet.setOwner(owner);
        model.addAttribute("pet", pet);
        return VIEW_PET_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/pets/new")
    public String processFromCreationForm(@Valid Pet pet, Owner owner, BindingResult bindingResult, Model model) {
        if(hasLength(pet.getName()) && pet.isNew() &&
                                    petService.findByNameContainingIgnoreCase(pet.getName()) != null) {
            bindingResult.rejectValue("name", "duplicate", "already exists");
        }
        owner.getPets().add(pet);
        pet.setOwner(owner);

        if(bindingResult.hasErrors()) {
            model.addAttribute("pet", pet);
            return VIEW_PET_CREATE_OR_UPDATE_FORM;
        } else {
            petService.save(pet);
            return "redirect:/owners/" + owner.getId();
        }
    }

    @GetMapping("/pets/{petId}/edit")
    public String initializeUpdatePetForm(@PathVariable("petId") Long petId, Model model) {
        Pet pet = petService.findById(petId);
        model.addAttribute("pet", pet);
        return VIEW_PET_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/pets/{petId}/edit")
    public String processUpdatePetForm(@Valid Pet pet, Owner owner, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            pet.setOwner(owner);
            model.addAttribute("pet", pet);
            return VIEW_PET_CREATE_OR_UPDATE_FORM;
        } else {
            owner.getPets().add(pet);
            petService.save(pet);
            return "redirect:/owners/" + owner.getId();
        }
    }

}
