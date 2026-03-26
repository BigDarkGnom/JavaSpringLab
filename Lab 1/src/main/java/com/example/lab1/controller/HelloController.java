package com.example.lab1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // /hello?name=Ivan → "Hello Ivan"
    // /hello → "Hello world!"
    @GetMapping("/hello")
    public String hello(@RequestParam(required = false) String name) {
        if (name != null && !name.isEmpty()) {
            return "Hello " + name;
        }
        return "Hello world!";
    }

    // /about → "about us"
    @GetMapping("/about")
    public String about() {
        return "about us";
    }

    // /options → "options"
    // /options?test=1 → "not an option"
    @GetMapping("/options")
    public String options(@RequestParam(required = false) String test) {
        if (test != null && !test.isEmpty()) {
            return "not an option";
        }
        return "options";
    }
}