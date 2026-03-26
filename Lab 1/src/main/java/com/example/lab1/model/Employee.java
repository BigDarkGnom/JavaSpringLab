package com.example.lab1.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Employee {
    private final Car car;
    private final Pet pet;
    private String name;
    private int age;

    // Конструктор для внедрения зависимостей (рекомендуемый способ)
    @Autowired
    public Employee(Car car, Pet pet) {
        this.car = car;
        this.pet = pet;
    }

    // Методы для установки имени и возраста (можно также через конструктор)
    public void setPersonalInfo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Бизнес-методы
    public String goToWork() {
        return name + " goes to work. " + car.drive();
    }

    public String playWithPet() {
        return name + " plays with " + pet.getName() + ". " + pet.makeSound();
    }

    public String getEmployeeInfo() {
        return "Employee{name='" + name + "', age=" + age +
                ", car=" + car + ", pet=" + pet + "}";
    }

    // Геттеры
    public Car getCar() { return car; }
    public Pet getPet() { return pet; }
    public String getName() { return name; }
    public int getAge() { return age; }
}