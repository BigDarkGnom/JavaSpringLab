package com.example.lab2.model;


import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component("cat")
public class Cat implements Pet {
    public Cat() {
        System.out.println("Class Cat: Constructor called");
    }

    @PostConstruct
    public void init() {
        System.out.println("Class Cat: init method (@PostConstruct)");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Class Cat: destroy method (@PreDestroy)");
    }

    @Override
    public void speak() {
        System.out.println("Cat says: Meow!");
    }
}