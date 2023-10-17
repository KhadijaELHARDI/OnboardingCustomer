package com.example.processclients.web;

import com.example.processclients.dtos.ContactDTO;
import com.example.processclients.exceptions.AuditNotFoundException;
import com.example.processclients.exceptions.ContactNotFoundException;
import com.example.processclients.services.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
@AllArgsConstructor
@CrossOrigin("*")
public class ContactRestController {
    private ContactService contactService;
    @PostMapping("/create")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public ContactDTO savedContact(@RequestBody ContactDTO contactDTO){
        return contactService.creer(contactDTO);
    }
    @PostMapping("/get/{id}")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public ContactDTO getContact(@PathVariable(name = "id") Long contactId) throws ContactNotFoundException {
        return  contactService.getContact(contactId);
    }
    @PutMapping("{contactId}")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ContactDTO updateContact(@PathVariable Long contactId,@RequestBody ContactDTO contactDTO){
        contactDTO.setId(contactId);
        return contactService.updateContact(contactDTO);
    }
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public void deleteContact(@PathVariable Long id){contactService.deleteContact(id);}
    @GetMapping("/search")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public List<ContactDTO> searchContact(@RequestParam(name = "keyword",defaultValue = "") String keyword){
        return contactService.searchContact("%"+keyword+"%");
    }
    @GetMapping("/lister")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public List<ContactDTO> listContact(){return  contactService.listContacts();}
}
