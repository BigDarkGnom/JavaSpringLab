package com.example.lab456.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "specialists")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Specialist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "ФИО не может быть пустым")
    private String fullName;

    @NotBlank(message = "Специализация не может быть пустой")
    private String specialization;

    @Min(value = 0, message = "Опыт не может быть отрицательным")
    private int experienceYears;

    @OneToMany(mappedBy = "specialist", fetch = FetchType.LAZY)
    private List<Pet> pets;
}