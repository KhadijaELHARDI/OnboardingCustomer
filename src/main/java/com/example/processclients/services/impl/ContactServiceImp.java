package com.example.processclients.services.impl;

import com.example.processclients.dtos.ContactDTO;
import com.example.processclients.entities.Contact;
import com.example.processclients.entities.Customer;
import com.example.processclients.exceptions.ContactNotFoundException;
import com.example.processclients.mappers.CustomerMapperImp;
import com.example.processclients.repositories.ContactRepository;
import com.example.processclients.repositories.CustomerRepository;
import com.example.processclients.services.ContactService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class ContactServiceImp implements ContactService {
    private ContactRepository contactRepository;
    private final CustomerRepository customerRepository;
    private CustomerMapperImp dtoMapper;

    @Override
    public ContactDTO creer(ContactDTO contactDTO) {
        Contact contact = new Contact();
        Long customerId = contactDTO.getCustomerId();
        if (customerId != null){
        Customer customer = customerRepository.findById(contactDTO.getCustomerId()).orElse(null);
        if (customer != null) {
            contact.setCustomerId(customer);
            contact.setAudAdd(contactDTO.getAudAdd());
            contact.setEmail(contactDTO.getEmail());
            contact.setFax(contactDTO.getFax());
            contact.setConType(contactDTO.getConType());
            contact.setConData(contactDTO.getConData());
            contact.setPhoneOff(contactDTO.getPhoneOff());
            contact.setIdPrePhone(contactDTO.getIdPrePhone());
            contact.setPhoneMobile(contactDTO.getPhoneMobile());
            contact.setPhoneRes(contactDTO.getPhoneRes());
            contact.setSecMessage(contactDTO.getSecMessage());
            Contact savedContact = contactRepository.save(contact);
            return dtoMapper.fromContact(savedContact);
        }}
        return null;
    }

    @Override
    public ContactDTO getContact(Long contactId) throws ContactNotFoundException {
        Contact contact=contactRepository.findById(contactId)
                .orElseThrow(()->new ContactNotFoundException("Contact Not Found"));
        return dtoMapper.fromContact(contact);
    }

    @Override
    public ContactDTO updateContact(ContactDTO contactDTO) {
        log.info("Saving new Contact");
        Contact contact=dtoMapper.fromContactDTO(contactDTO);
        Contact savedContact=contactRepository.save(contact);
        return dtoMapper.fromContact(savedContact);
    }

    @Override
    public void deleteContact(Long contactId) {
        contactRepository.deleteById(contactId);

    }

    @Override
    public List<ContactDTO> listContacts() {
        List<Contact> contacts=contactRepository.findAll();
        List<ContactDTO> contactDTOS=contacts.stream()
                .map(contact -> dtoMapper.fromContact(contact))
                .collect(Collectors.toList());
        return contactDTOS;
    }

    @Override
    public List<ContactDTO> searchContact(String keyword) {
        List<Contact> contacts=contactRepository.searchContact(keyword);
        List<ContactDTO> contactDTOS=contacts.stream().map(cont->dtoMapper.fromContact(cont)).collect(Collectors.toList());
        return contactDTOS;
    }

}
