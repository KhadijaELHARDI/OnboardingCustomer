package com.example.processclients.services;

import com.example.processclients.dtos.CustomerDTO;

import com.example.processclients.exceptions.ContactNotFoundException;
import com.example.processclients.exceptions.CustomerNotFoundException;
import com.example.processclients.exceptions.DeletedCustomerNotFoundException;

import java.util.List;

public interface CustomerService {
    CustomerDTO creer(CustomerDTO customerDTO);
    CustomerDTO getCustomer(Long customerId) throws CustomerNotFoundException;
   CustomerDTO updateCustomer(CustomerDTO customerDTO);
    void deleteCustomer(Long customerId) throws CustomerNotFoundException;
    List<CustomerDTO> listCustomers();
    List<CustomerDTO> searchCustomers(String keyword);
}
