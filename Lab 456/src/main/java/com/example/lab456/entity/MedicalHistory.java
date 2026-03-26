package com.example.lab456.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "medical_histories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicalHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Диагноз не может быть пустым")
    private String diagnosis;

    @NotBlank(message = "Лечение не может быть пустым")
    private String treatment;

    private LocalDate date;

    @OneToOne(mappedBy = "medicalHistory", fetch = FetchType.LAZY)
    private Pet pet;
}