package com.example.processclients.services.impl;

import com.example.processclients.dtos.CustomerDTO;
import com.example.processclients.entities.Customer;
import com.example.processclients.entities.DeletedCustomer;
import com.example.processclients.exceptions.ContactNotFoundException;
import com.example.processclients.exceptions.CustomerNotFoundException;
import com.example.processclients.exceptions.DeletedCustomerNotFoundException;
import com.example.processclients.mappers.CustomerMapperImp;
import com.example.processclients.repositories.CustomerRepository;
import com.example.processclients.repositories.DeletedCustomerRepository;
import com.example.processclients.services.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class CustomerServiceImp implements CustomerService {
private CustomerRepository customerRepository;
private DeletedCustomerRepository deletedCustomerRepository;
    private CustomerMapperImp dtoMapper;

    @Override
    public CustomerDTO creer(CustomerDTO customerDTO)   {
        Customer customer=new Customer();
        customer.setCustBirthCity(customerDTO.getCustBirthCity());
        customer.setCustBirthCountry(customerDTO.getCustBirthCountry());
        customer.setCustBirthProvince(customerDTO.getCustBirthProvince());
        customer.setCustomerRating(customerDTO.getCustomerRating());
        customer.setCustomerStatus(customerDTO.getCustomerStatus());
        customer.setCustomerType(customerDTO.getCustomerType());
        customer.setDateOfBirth(customerDTO.getDateOfBirth());
        customer.setFamilyName(customerDTO.getFamilyName());
        customer.setGender(customerDTO.getGender());
        customer.setIndustry(customerDTO.getIndustry());
        customer.setLanguage(customerDTO.getLanguage());
        customer.setMaritalStatus(customerDTO.getMaritalStatus());
        customer.setMnemonic(customerDTO.getMnemonic());
        customer.setNationality(customerDTO.getNationality());
        customer.setResidence(customerDTO.getResidence());
        customer.setSalutation(customerDTO.getSalutation());
        customer.setSecondOfficer(customerDTO.getSecondOfficer());
        customer.setSector(customerDTO.getSector());
        customer.setTarget(customerDTO.getTarget());
        customer.setVulnerability(customerDTO.getVulnerability());
        customer.setAccountOfficer(customerDTO.getAccountOfficer());
        customer.setGivenName(customerDTO.getGivenName());
        customer.setShortName(customerDTO.getShortName());
        customer.setTitle(customerDTO.getTitle());
        customer.setFullName(customerDTO.getFullName());


        Customer savedCustomer=customerRepository.save(customer);
        return dtoMapper.fromCustomer(savedCustomer);

    }

    @Override
    public CustomerDTO getCustomer(Long customerId) throws CustomerNotFoundException {
        Customer customer=customerRepository.findById(customerId)
                .orElseThrow(()->new CustomerNotFoundException("Customer Not Found"));

        return dtoMapper.fromCustomer(customer);
    }

    @Override
    public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
       log.info("Saving new Customer");
       Customer customer=dtoMapper.fromCustomerDT0(customerDTO);
       Customer savedCustomer=customerRepository.save(customer);
        return dtoMapper.fromCustomer(savedCustomer);
    }

    @Override
    @Transactional
    public void deleteCustomer(Long customerId) throws CustomerNotFoundException {

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer Not Found"));

        DeletedCustomer deletedCustomer = new DeletedCustomer();


        Customer originalCustomer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer Not Found"));


        if (originalCustomer != null) {
            //deletedCustomer.setOriginalCustomer(originalCustomer);
            deletedCustomer.setDeletionDate(new Date());
            deletedCustomer.setFullName(originalCustomer.getFullName());
            deletedCustomer.setJob(originalCustomer.getSector());
            deletedCustomer.setDateBirth(originalCustomer.getDateOfBirth());


            deletedCustomerRepository.save(deletedCustomer);


            customerRepository.delete(originalCustomer);
        }
        }








    @Override
    public List<CustomerDTO> listCustomers() {
        List<Customer> customers=customerRepository.findAll();
        List<CustomerDTO> customerDTOS=customers.stream()
                .map(customer -> dtoMapper.fromCustomer(customer))
                .collect(Collectors.toList());
        return customerDTOS;
    }

    @Override
    public List<CustomerDTO> searchCustomers(String keyword) {
      List<Customer>customers=customerRepository.searchCustomer(keyword);
      List<CustomerDTO> customerDTOS=customers.stream().map(cust->dtoMapper.fromCustomer(cust)).collect(Collectors.toList());
        return customerDTOS;
    }


}

