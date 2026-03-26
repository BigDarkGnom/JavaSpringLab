package com.example.lab2.config;

import com.example.lab2.model.Car;
import com.example.lab2.model.Dog;
import com.example.lab2.model.Employee;
import com.example.lab2.model.Pet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:app.properties")
public class JavaConfig {

    // Явное создание бина Car
    @Bean
    public Car car() {
        Car car = new Car();
        car.setModel("BMW");
        return car;
    }

    // Явное создание бина Pet (Dog)
    @Bean(name = "dog")
    public Pet pet() {
        return new Dog();
    }

    // Явное создание бина Employee и внедрение зависимостей кодом
    @Bean
    public Employee employee(Car car, Pet pet) {
        Employee employee = new Employee();
        // Внедрение зависимостей через сеттеры (так как в классе они есть)
        employee.setCar(car);
        employee.setPet(pet);
        return employee;
    }

    // Необходим для обработки @Value в Java Config без XML
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}