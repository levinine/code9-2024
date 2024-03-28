package com.levinine.codenine.secured.controllers;

import com.levinine.codenine.secured.dtos.HelloDto;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/hello")
public class HelloController {

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public HelloDto helloFromEveryone() {
        return new HelloDto("from everyone");
    }

    @Secured("ROLE_ADMIN")
    @GetMapping(path = "/admin", produces = MediaType.APPLICATION_JSON_VALUE)
    public HelloDto helloFromAdmin() {
        return new HelloDto("from admin");
    }

    @Secured("ROLE_USER")
    @GetMapping(path = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public HelloDto helloFromUser() {
        return new HelloDto("from user");
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @GetMapping(path = "/any", produces = MediaType.APPLICATION_JSON_VALUE)
    public HelloDto helloFromUserOrAdmin() {
        return new HelloDto("from any authenticated person");
    }
}
