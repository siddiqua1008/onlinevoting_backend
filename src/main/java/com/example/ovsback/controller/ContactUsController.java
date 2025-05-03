package com.example.ovsback.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.ovsback.model.ContactUs;
import com.example.ovsback.service.ContactUsService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/contactus")
public class ContactUsController {

    @Autowired
    private ContactUsService contactUsService;

    @PostMapping
    public ResponseEntity<ContactUs> saveMessage(@RequestBody ContactUs contactUs) {
        return new ResponseEntity<>(contactUsService.save(contactUs), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ContactUs>> getAllMessages() {
        return new ResponseEntity<>(contactUsService.getAllMessages(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactUs> getMessageById(@PathVariable int id) {
        return new ResponseEntity<>(contactUsService.getMessageById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable int id) {
        contactUsService.deleteMessage(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}