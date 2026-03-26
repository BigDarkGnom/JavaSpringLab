package com.example.lab1.controller;


import com.example.lab1.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final Employee employee;

    @Autowired
    public EmployeeController(Employee employee) {
        this.employee = employee;
    }

    @GetMapping("/info")
    public String getEmployeeInfo(@RequestParam String name, @RequestParam int age) {
        employee.setPersonalInfo(name, age);
        return employee.getEmployeeInfo();
    }

    @GetMapping("/work")
    public String goToWork(@RequestParam String name, @RequestParam int age) {
        employee.setPersonalInfo(name, age);
        return employee.goToWork();
    }

    @GetMapping("/play")
    public String playWithPet(@RequestParam String name, @RequestParam int age) {
        employee.setPersonalInfo(name, age);
        return employee.playWithPet();
    }
}