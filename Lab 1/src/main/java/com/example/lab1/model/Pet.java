package com.example.lab1.model;


import org.springframework.stereotype.Component;

@Component
public class Pet {
    private String name;
    private String type;

    public Pet() {
        this.name = "Barsik";
        this.type = "cat";
    }

    public Pet(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String makeSound() {
        return type.equals("dog") ? "Woof!" : "Meow!";
    }

    // Геттеры и сеттеры
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    @Override
    public String toString() {
        return "Pet{" + "name='" + name + '\'' + ", type='" + type + '\'' + '}';
    }
}ые