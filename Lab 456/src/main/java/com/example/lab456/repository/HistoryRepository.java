package com.example.lab456.repository;
import com.example.lab456.entity.MedicalHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepository extends JpaRepository<MedicalHistory, Long> {
}