package com.example.processclients.web;
import com.example.processclients.dtos.CustomerDTO;
import com.example.processclients.exceptions.CustomerNotFoundException;
import com.example.processclients.exceptions.DeletedCustomerNotFoundException;
import com.example.processclients.services.CustomerService;
import com.example.processclients.services.impl.CustomerServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
@CrossOrigin("*")
public class CustomerRestController {
    private CustomerService customerService;
    @PostMapping("/create")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO){
        return customerService.creer(customerDTO);
    }
    @PostMapping("/get/{id}")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public CustomerDTO getCustomer(@PathVariable(name = "id") Long customerId) throws CustomerNotFoundException {
        return customerService.getCustomer(customerId);
    }
    @PutMapping("/{customerId}")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
  public CustomerDTO updateCustomer(@PathVariable Long customerId,@RequestBody CustomerDTO customerDTO){
        customerDTO.setId(customerId);
        return customerService.updateCustomer(customerDTO);
  }
  @DeleteMapping("/delete/{id}")
  @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
public void deleteCustomer(@PathVariable Long id) throws CustomerNotFoundException {
    customerService.deleteCustomer(id);
}
@GetMapping("/search")
@PreAuthorize("hasAuthority('SCOPE_ADMIN')")
public List<CustomerDTO> searchCustomer(@RequestParam(name = "keyword",defaultValue = "") String keyword){
        return customerService.searchCustomers("%"+keyword+"%");
}
@GetMapping("/lister")
@PreAuthorize("hasAuthority('SCOPE_ADMIN')")
public List<CustomerDTO> listCustomer(){
        return customerService.listCustomers();
}

}
