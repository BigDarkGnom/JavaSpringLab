package com.example.lab2.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class Employee {
    @Value("${employee.name:Default Name}") // Демонстрация @Value
    private String name;

    private Car car;
    private Pet pet;

    public Employee() {
        System.out.println("Class Employee: Constructor called");
    }

    @Autowired
    public void setCar(Car car) { // Демонстрация @Autowired на сеттере
        System.out.println("Class Employee: Setter setCar called");
        this.car = car;
    }

    @Autowired
    @Qualifier("dog") // Демонстрация @Qualifier (выбираем Dog из двух Pet)
    public void setPet(Pet pet) {
        System.out.println("Class Employee: Setter setPet called");
        this.pet = pet;
    }

    @PostConstruct
    public void init() {
        System.out.println("Class Employee: init method (@PostConstruct). Name: " + name);
        if(pet != null) pet.speak();
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Class Employee: destroy method (@PreDestroy)");
    }

    @Override
    public String toString() {
        return "Employee{" + "name='" + name + '\'' + ", car=" + car + '}';
    }
}