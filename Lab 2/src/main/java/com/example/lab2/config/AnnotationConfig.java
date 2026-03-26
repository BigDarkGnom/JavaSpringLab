package com.example.lab2.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.example.lab2.model") // Сканирование пакета
@PropertySource("classpath:app.properties") // Подключение свойств для @Value
public class AnnotationConfig {
}