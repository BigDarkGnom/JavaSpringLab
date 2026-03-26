package com.example.lab2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.lab2.config.AnnotationConfig;
import com.example.lab2.config.JavaConfig;
import com.example.lab2.model.Employee;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@SpringBootApplication
public class Lab2Application {

    public static void main(String[] args) {
        System.out.println("=== ЗАПУСК ЧЕРЕЗ АННОТАЦИИ (Component Scan) ===");
        // Используем ConfigurableApplicationContext для доступа к методу close()
        ConfigurableApplicationContext contextAnnotation = new AnnotationConfigApplicationContext(AnnotationConfig.class);
        Employee employee1 = contextAnnotation.getBean(Employee.class);
        System.out.println("Bean Employee (Annotation): " + employee1);
        contextAnnotation.close(); // Теперь метод доступен и вызовет @PreDestroy

        System.out.println("\n=== ЗАПУСК ЧЕРЕЗ JAVA CONFIG (Без сканирования) ===");
        ConfigurableApplicationContext contextJava = new AnnotationConfigApplicationContext(JavaConfig.class);
        Employee employee2 = contextJava.getBean(Employee.class);
        System.out.println("Bean Employee (Java Config): " + employee2);
        contextJava.close(); // Теперь метод доступен и вызовет @PreDestroy
    }

}
