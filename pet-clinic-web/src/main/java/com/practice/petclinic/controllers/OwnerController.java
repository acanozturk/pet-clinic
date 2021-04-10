package com.practice.petclinic.controllers;

import com.practice.petclinic.model.Owner;
import com.practice.petclinic.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;
    private static final String VIEW_OWNER_CREATE_OR_UPDATE_FORM = "owners/createOrUpdateOwnerForm";

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder webDataBinder) {
        webDataBinder.setDisallowedFields("id");
    }

    @RequestMapping("/find")
    public String listOfOwners(Model model) {
        Owner owner = new Owner();
        model.addAttribute("owner", owner);
        return "owners/findOwners";
    }

    @GetMapping("/{ownerId}")
    public ModelAndView displayOwner(@PathVariable("ownerId") Long ownerId) {
        ModelAndView modelAndView = new ModelAndView("owners/ownerDetails");
        modelAndView.addObject(ownerService.findById(ownerId));
        return modelAndView;
    }

    @GetMapping
    public String findOwner(Owner owner, BindingResult bindingResult, Model model) {
        if(owner.getLastName() == null) {
            owner.setLastName("");
        }

        List<Owner> results = ownerService.findByLastNameContainingIgnoreCase(owner.getLastName());

        if(results.isEmpty()) {
            bindingResult.rejectValue("lastName", "notFound", "not found");
            return "owners/findOwners";
        } else if(results.size() == 1) {
            owner = results.get(0);
            return "redirect:/owners/" + owner.getId();
        } else {
            model.addAttribute("selections", results);
            return "owners/ownersList";
        }
    }

    @GetMapping("/new")
    public String initializeCreationForm(Model model) {
        Owner owner = new Owner();
        model.addAttribute("owner", owner);
        return VIEW_OWNER_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/new")
    public String processFromCreationForm(@Valid Owner owner, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return VIEW_OWNER_CREATE_OR_UPDATE_FORM;
        } else {
            Owner savedOwner = ownerService.save(owner);
            return "redirect:/owners/" + savedOwner.getId();
        }
    }

    @GetMapping("/{ownerId}/edit")
    public String initializeUpdateOwnerForm(@PathVariable("ownerId") Long ownerId, Model model) {
        model.addAttribute(ownerService.findById(ownerId));
        return VIEW_OWNER_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/{ownerId}/edit")
    public String processUpdateOwnerForm(@Valid Owner owner, BindingResult bindingResult,
                                         @PathVariable("ownerId") Long ownerId) {
        if(bindingResult.hasErrors()) {
            return VIEW_OWNER_CREATE_OR_UPDATE_FORM;
        } else {
            owner.setId(ownerId);
            Owner savedOwner = ownerService.save(owner);
            return "redirect:/owners/" + savedOwner.getId();
        }
    }
}
