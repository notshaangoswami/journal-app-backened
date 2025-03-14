package net.engineeringdigest.journalApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {

    @GetMapping
    public String topPage(){
        return "home page new 2";
    }
    @GetMapping("/hello")
    public String healthCheck(){
        return " hello health check";
    }
}







