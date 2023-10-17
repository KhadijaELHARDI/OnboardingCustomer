package com.example.processclients.repositories;

import com.example.processclients.entities.Customer;
import com.example.processclients.entities.DeletedCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeletedCustomerRepository extends JpaRepository<DeletedCustomer,Long> {




    List<DeletedCustomer> findByOriginalCustomer(Customer customerToDelete);
}
