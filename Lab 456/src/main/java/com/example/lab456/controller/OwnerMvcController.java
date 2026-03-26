
package com.example.lab456.controller;

import com.example.lab456.entity.Owner;
import com.example.lab456.repository.OwnerRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/owners")
public class OwnerMvcController {

    @Autowired
    private OwnerRepository ownerRepository;

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("owner", new Owner());
        return "owner-form";
    }

    @PostMapping("/save")
    public String saveOwner(@Valid @ModelAttribute("owner") Owner owner,
                            BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "owner-form";
        }
        ownerRepository.save(owner);
        return "redirect:/owners/list";
    }

    @GetMapping("/list")
    public String listOwners(Model model) {
        model.addAttribute("owners", ownerRepository.findAll());
        return "owner-list";
    }

    @GetMapping("/delete/{id}")
    public String deleteOwner(@PathVariable Long id) {
        ownerRepository.deleteById(id);
        return "redirect:/owners/list";
    }
}