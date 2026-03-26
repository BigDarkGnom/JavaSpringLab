
package com.example.lab456.rest;

import com.example.lab456.entity.Specialist;
import com.example.lab456.repository.SpecialistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/specialists")
public class SpecialistRestController {

    @Autowired
    private SpecialistRepository specialistRepository;

    @PostMapping
    public ResponseEntity<Specialist> createSpecialist(@RequestBody Specialist specialist) {
        return ResponseEntity.ok(specialistRepository.save(specialist));
    }

    @GetMapping
    public List<Specialist> getAllSpecialists() {
        return specialistRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Specialist> getSpecialistById(@PathVariable Long id) {
        return specialistRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Specialist> updateSpecialist(@PathVariable Long id,
                                                       @RequestBody Specialist specialistDetails) {
        return specialistRepository.findById(id).map(specialist -> {
            specialist.setFullName(specialistDetails.getFullName());
            specialist.setSpecialization(specialistDetails.getSpecialization());
            specialist.setExperienceYears(specialistDetails.getExperienceYears());
            return ResponseEntity.ok(specialistRepository.save(specialist));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSpecialist(@PathVariable Long id) {
        return specialistRepository.findById(id).map(specialist -> {
            specialistRepository.delete(specialist);
            return ResponseEntity.ok().<Void>build();
        }).orElse(ResponseEntity.notFound().build());
    }
}