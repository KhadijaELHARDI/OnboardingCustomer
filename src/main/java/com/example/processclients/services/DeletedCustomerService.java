package com.example.processclients.services;

import com.example.processclients.dtos.DeletedCustomerDTO;
import com.example.processclients.exceptions.DeletedCustomerNotFoundException;

import java.util.List;

public interface DeletedCustomerService {
     List<DeletedCustomerDTO> listDeletedCustomers();
     void restoreDeletedCustomer(Long deletedCustomerId) throws DeletedCustomerNotFoundException;
}
