package com.example.lab456.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "pets")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Имя не может быть пустым")
    @Size(min = 2, max = 50, message = "Имя от 2 до 50 символов")
    private String name;

    @NotBlank(message = "Тип не может быть пустым")
    private String type;

    @Min(value = 0, message = "Возраст не может быть отрицательным")
    private int age;

    private String gender;
    private boolean vaccinated;

    // 1 к 1 с Историей болезни
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "history_id")
    private MedicalHistory medicalHistory;

    // Многие к 1 со Специалистом
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "specialist_id")
    private Specialist specialist;

    // Многие ко многим с Хозяевами
    @ManyToMany(mappedBy = "pets", fetch = FetchType.LAZY)
    private List<Owner> owners;
}