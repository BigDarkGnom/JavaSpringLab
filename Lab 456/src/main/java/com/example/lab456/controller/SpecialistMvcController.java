
package com.example.lab456.controller;

import com.example.lab456.entity.Specialist;
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
@RequestMapping("/specialists")
public class SpecialistMvcController {

    @Autowired
    private SpecialistRepository specialistRepository;

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("specialist", new Specialist());
        model.addAttribute("specializations",
                Arrays.asList("Therapist", "Surgeon", "Dermatologist", "Cardiologist", "Neurologist"));
        return "specialist-form";
    }

    @PostMapping("/save")
    public String saveSpecialist(@Valid @ModelAttribute("specialist") Specialist specialist,
                                 BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("specializations",
                    Arrays.asList("Therapist", "Surgeon", "Dermatologist", "Cardiologist", "Neurologist"));
            return "specialist-form";
        }
        specialistRepository.save(specialist);
        return "redirect:/specialists/list";
    }

    @GetMapping("/list")
    public String listSpecialists(Model model) {
        model.addAttribute("specialists", specialistRepository.findAll());
        return "specialist-list";
    }

    @GetMapping("/delete/{id}")
    public String deleteSpecialist(@PathVariable Long id) {
        specialistRepository.deleteById(id);
        return "redirect:/specialists/list";
    }
}