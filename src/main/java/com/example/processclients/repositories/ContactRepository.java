package com.example.processclients.repositories;

import com.example.processclients.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact,Long> {
    @Query("select co from  Contact  co where co.email like :kw")
    List<Contact> searchContact(@Param("kw") String keyword);
}
