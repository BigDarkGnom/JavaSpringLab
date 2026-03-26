package com.example.lab1.model;


import org.springframework.stereotype.Component;

@Component
public class Car {
    private String brand;
    private String model;

    public Car() {
        this.brand = "Toyota";
        this.model = "Camry";
    }

    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public String drive() {
        return "Driving " + brand + " " + model;
    }

    // Геттеры и сеттеры
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    @Override
    public String toString() {
        return "Car{" + "brand='" + brand + '\'' + ", model='" + model + '\'' + '}';
    }
}