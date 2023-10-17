package com.example.processclients.web;

import com.example.processclients.dtos.DeletedCustomerDTO;
import com.example.processclients.exceptions.DeletedCustomerNotFoundException;
import com.example.processclients.services.DeletedCustomerService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/DeletedCustomers")
@AllArgsConstructor
@CrossOrigin("*")

public class DeletedCustomerRestController {
    private DeletedCustomerService deletedCustomerService;
    @GetMapping("/lister")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
 public List<DeletedCustomerDTO> listDeletedCustomers(){
     return  deletedCustomerService.listDeletedCustomers(); }
    @PutMapping("restore/{deletedCustomerId}")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    @ResponseBody
    public void restoreDeletedCustomer(@PathVariable Long deletedCustomerId) throws DeletedCustomerNotFoundException {
        deletedCustomerService.restoreDeletedCustomer(deletedCustomerId);
    }

}
