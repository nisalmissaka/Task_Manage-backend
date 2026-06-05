package edu.example.controller;

import edu.example.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contact/")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @GetMapping("/greet")
    public String hello(){
        return "Hello World! This is a contact API";
    }
}
