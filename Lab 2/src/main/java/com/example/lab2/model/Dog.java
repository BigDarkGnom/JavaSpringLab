package com.example.lab2.model;


import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component("dog") // Квалификатор для имени бина
public class Dog implements Pet {
    public Dog() {
        System.out.println("Class Dog: Constructor called");
    }

    @PostConstruct
    public void init() {
        System.out.println("Class Dog: init method (@PostConstruct)");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Class Dog: destroy method (@PreDestroy)");
    }

    @Override
    public void speak() {
        System.out.println("Dog says: Gav!");
    }
}