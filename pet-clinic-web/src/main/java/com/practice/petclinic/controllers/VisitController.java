package com.practice.petclinic.controllers;

import com.practice.petclinic.model.Pet;
import com.practice.petclinic.model.Visit;
import com.practice.petclinic.services.PetService;
import com.practice.petclinic.services.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/owners")
@Controller
public class VisitController {

    private final VisitService visitService;
    private final PetService petService;
    private static final String VIEW_PET_CREATE_OR_UPDATE_VISIT_FORM = "pets/createOrUpdateVisitForm";

    @Autowired
    public VisitController(VisitService visitService, PetService petService) {
        this.visitService = visitService;
        this.petService = petService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder webDataBinder) {
        webDataBinder.setDisallowedFields("id");
    }

    @ModelAttribute("visit")
    public Visit loadPetWithVisits(@PathVariable("petId") Long petId, Model model) {
        Pet pet = petService.findById(petId);
        model.addAttribute("pet", pet);

        Visit visit = new Visit();
        pet.getVisits().add(visit);
        return visit;
    }

    @GetMapping("/*/pets/{petId}/visits/new")
    public String initializeNewVisitForm() {
        return VIEW_PET_CREATE_OR_UPDATE_VISIT_FORM;
    }

    @PostMapping("/{ownerId}/pets/{petId}/visits/new")
    public String processNewVisitForm(@Valid Visit visit, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return VIEW_PET_CREATE_OR_UPDATE_VISIT_FORM;
        } else {
            visitService.save(visit);
            return "redirect:/owners/{ownerId}";
        }
    }

}
