
package com.example.lab456.controller;

import com.example.lab456.entity.Pet;
import com.example.lab456.entity.Specialist;
import com.example.lab456.repository.PetRepository;
import com.example.lab456.repository.SpecialistRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/pets")
public class PetMvcController {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private SpecialistRepository specialistRepository;

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("pet", new Pet());
        model.addAttribute("types", Arrays.asList("Cat", "Dog", "Bird", "Hamster", "Fish"));
        model.addAttribute("genders", Arrays.asList("Male", "Female"));
        model.addAttribute("specialists", specialistRepository.findAll());
        return "pet-form";
    }

    @PostMapping("/save")
    public String savePet(@Valid @ModelAttribute("pet") Pet pet,
                          BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("types", Arrays.asList("Cat", "Dog", "Bird", "Hamster", "Fish"));
            model.addAttribute("genders", Arrays.asList("Male", "Female"));
            model.addAttribute("specialists", specialistRepository.findAll());
            return "pet-form";
        }
        petRepository.save(pet);
        return "redirect:/pets/list";
    }

    @GetMapping("/list")
    public String listPets(Model model) {
        model.addAttribute("pets", petRepository.findAll());
        return "pet-list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Pet pet = petRepository.findById(id).orElseThrow();
        model.addAttribute("pet", pet);
        model.addAttribute("types", Arrays.asList("Cat", "Dog", "Bird", "Hamster", "Fish"));
        model.addAttribute("genders", Arrays.asList("Male", "Female"));
        model.addAttribute("specialists", specialistRepository.findAll());
        return "pet-form";
    }

    @GetMapping("/delete/{id}")
    public String deletePet(@PathVariable Long id) {
        petRepository.deleteById(id);
        return "redirect:/pets/list";
    }
}