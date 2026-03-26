package com.example.lab3;

import com.example.lab3.exception.ItemNotFoundException;
import com.example.lab3.model.*;
import com.example.lab3.service.Warehouse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Lab3Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Lab3Application.class, args);
        Warehouse warehouse = context.getBean(Warehouse.class);

        System.out.println("=== 1. Помещение предметов на склад (Trigger @Before, @After) ===");
        new Laptop().goToWarehouse(warehouse);
        new Chair().goToWarehouse(warehouse);
        new Apple().goToWarehouse(warehouse);

        System.out.println("\n=== 2. Получение предмета (Trigger @Around, @AfterReturning, @After) ===");
        warehouse.getItem("Laptop");

        System.out.println("\n=== 3. Получение несуществующего предмета (Trigger @Around, @AfterReturning, @After) ===");
        warehouse.getItem("Tank");

        System.out.println("\n=== 4. Строгий поиск с ошибкой (Trigger @AfterThrowing, @After) ===");
        try {
            warehouse.getItemStrict("Tank");
        } catch (ItemNotFoundException e) {
            System.out.println(">> Главное приложение поймало исключение: " + e.getMessage());
        }

        context.close();
    }
}