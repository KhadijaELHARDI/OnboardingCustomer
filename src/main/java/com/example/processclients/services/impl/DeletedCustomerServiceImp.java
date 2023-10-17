package com.example.processclients.services.impl;

import com.example.processclients.dtos.DeletedCustomerDTO;
import com.example.processclients.entities.Customer;
import com.example.processclients.entities.DeletedCustomer;
import com.example.processclients.exceptions.DeletedCustomerNotFoundException;
import com.example.processclients.mappers.CustomerMapperImp;
import com.example.processclients.repositories.CustomerRepository;
import com.example.processclients.repositories.DeletedCustomerRepository;
import com.example.processclients.services.DeletedCustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j

public class DeletedCustomerServiceImp implements DeletedCustomerService {
    private CustomerMapperImp dtoMapper;
    private CustomerRepository customerRepository;
    private final DeletedCustomerRepository deletedCustomerRepository;
    @Override
    public List<DeletedCustomerDTO> listDeletedCustomers() {
        List<DeletedCustomer> deletedCustomers = deletedCustomerRepository.findAll();
        System.out.println(deletedCustomers);
        return deletedCustomers.stream()
                .map(deletedCustomer -> dtoMapper.fromDeletedCustomer(deletedCustomer))
                .collect(Collectors.toList());
    }

    @Override
    public void restoreDeletedCustomer(Long deletedCustomerId)throws DeletedCustomerNotFoundException {
        DeletedCustomer deletedCustomer = deletedCustomerRepository.findById(deletedCustomerId)
                .orElseThrow(() -> new DeletedCustomerNotFoundException("Deleted Customer Not Found"));

        // Supprimer l'enregistrement deletedCustomer de la base de données
        deletedCustomerRepository.delete(deletedCustomer);


    }
}
