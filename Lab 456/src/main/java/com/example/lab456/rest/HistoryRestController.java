
package com.example.lab456.rest;

import com.example.lab456.entity.MedicalHistory;
import com.example.lab456.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/histories")
public class HistoryRestController {

    @Autowired
    private HistoryRepository historyRepository;

    @PostMapping
    public ResponseEntity<MedicalHistory> createHistory(@RequestBody MedicalHistory history) {
        return ResponseEntity.ok(historyRepository.save(history));
    }

    @GetMapping
    public List<MedicalHistory> getAllHistories() {
        return historyRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicalHistory> getHistoryById(@PathVariable Long id) {
        return historyRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicalHistory> updateHistory(@PathVariable Long id,
                                                        @RequestBody MedicalHistory historyDetails) {
        return historyRepository.findById(id).map(history -> {
            history.setDiagnosis(historyDetails.getDiagnosis());
            history.setTreatment(historyDetails.getTreatment());
            history.setDate(historyDetails.getDate());
            return ResponseEntity.ok(historyRepository.save(history));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHistory(@PathVariable Long id) {
        return historyRepository.findById(id).map(history -> {
            historyRepository.delete(history);
            return ResponseEntity.ok().<Void>build();
        }).orElse(ResponseEntity.notFound().build());
    }
}