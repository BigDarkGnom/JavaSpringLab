
package com.example.lab456.controller;

import com.example.lab456.entity.MedicalHistory;
import com.example.lab456.repository.HistoryRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/histories")
public class HistoryMvcController {

    @Autowired
    private HistoryRepository historyRepository;

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("history", new MedicalHistory());
        return "history-form";
    }

    @PostMapping("/save")
    public String saveHistory(@Valid @ModelAttribute("history") MedicalHistory history,
                              BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "history-form";
        }
        historyRepository.save(history);
        return "redirect:/histories/list";
    }

    @GetMapping("/list")
    public String listHistories(Model model) {
        model.addAttribute("histories", historyRepository.findAll());
        return "history-list";
    }

    @GetMapping("/delete/{id}")
    public String deleteHistory(@PathVariable Long id) {
        historyRepository.deleteById(id);
        return "redirect:/histories/list";
    }
}