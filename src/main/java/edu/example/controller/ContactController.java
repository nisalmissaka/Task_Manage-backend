package edu.example.controller;

import edu.example.dto.ApiResponse;
import edu.example.model.Contact;
import edu.example.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @GetMapping("/greet")
    public String hello(){
        return "Hello World! This is a contact API";
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Contact>>> getAllContacts(){
        return ResponseEntity.ok(contactService.getAllContacts());
    }
    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Contact>> createContact(@RequestBody Contact contact) {
        return ResponseEntity.ok(contactService.addContact(contact));
    }
}
