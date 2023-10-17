package com.example.processclients.repositories;

import com.example.processclients.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Long> {
    @Query("select  a from Address  a where  a.addressCountry like :kw")
    List<Address> searchAddress(@Param("kw") String keyword);
}
