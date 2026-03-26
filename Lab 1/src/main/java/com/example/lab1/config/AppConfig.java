package com.example.lab1.config;

import com.example.lab1.model.Car;
import com.example.lab1.model.Pet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Car luxuryCar() {
        return new Car("Mercedes", "E-Class");
    }

    @Bean
    public Pet myDog() {
        return new Pet("Rex", "dog");
    }
}