package net.engineeringdigest.journalApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {

    @GetMapping
    public String topPage(){
        return "home page";
    }
    @GetMapping("/hello")
    public String healthCheck(){
        return "health check";
    }
}
