package com.example.processclients.services;

import com.example.processclients.dtos.AuditDTO;
import com.example.processclients.dtos.ContactDTO;
import com.example.processclients.exceptions.AuditNotFoundException;
import com.example.processclients.exceptions.ContactNotFoundException;

import java.util.List;

public interface ContactService {
    ContactDTO creer(ContactDTO contactDTO);
    ContactDTO getContact(Long contactId) throws ContactNotFoundException;
    ContactDTO updateContact(ContactDTO contactDTO);
    void deleteContact(Long contactId);
    List<ContactDTO> listContacts();
    List<ContactDTO> searchContact(String keyword);
}
