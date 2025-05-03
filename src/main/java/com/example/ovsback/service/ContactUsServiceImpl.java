package com.example.ovsback.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ovsback.exception.ResourceNotFoundException;
import com.example.ovsback.model.ContactUs;
import com.example.ovsback.repository.ContactUsRepository;

@Service
public class ContactUsServiceImpl implements ContactUsService {

    @Autowired
    private ContactUsRepository contactUsRepository;

    @Override
    public ContactUs save(ContactUs contactUs) {
        return contactUsRepository.save(contactUs);
    }

    @Override
    public List<ContactUs> getAllMessages() {
        return contactUsRepository.findAll();
    }

    @Override
    public ContactUs getMessageById(int id) {
        return contactUsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Message not found with id " + id));
    }

    @Override
    public void deleteMessage(int id) {
        ContactUs contactUs = contactUsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Message not found with id " + id));
        contactUsRepository.delete(contactUs);
    }
}
