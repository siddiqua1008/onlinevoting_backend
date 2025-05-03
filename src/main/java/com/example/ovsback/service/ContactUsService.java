package com.example.ovsback.service;

import java.util.List;
import com.example.ovsback.model.ContactUs;

public interface ContactUsService {
    ContactUs save(ContactUs contactUs);
    List<ContactUs> getAllMessages();
    ContactUs getMessageById(int id);
    void deleteMessage(int id);
}
