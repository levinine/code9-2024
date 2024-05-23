package com.spring.docker.assignment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockerAssignmentController {

    @GetMapping("")
    public String sayHallo() {
        return "Hello from Spring";
    }

}
