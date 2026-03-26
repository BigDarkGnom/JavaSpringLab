package com.example.lab2.model;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@Scope("prototype") // Демонстрация аннотации @Scope
public class Car {
    private String model = "Toyota";

    public Car() {
        System.out.println("Class Car: Constructor called");
    }

    public void setModel(String model) {
        System.out.println("Class Car: Setter setModel called");
        this.model = model;
    }

    @PostConstruct
    public void init() {
        System.out.println("Class Car: init method (@PostConstruct)");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Class Car: destroy method (@PreDestroy)");
    }

    @Override
    public String toString() {
        return "Car{" + "model='" + model + '\'' + '}';
    }
}