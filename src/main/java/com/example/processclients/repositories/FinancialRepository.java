package com.example.processclients.repositories;

import com.example.processclients.entities.Financial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FinancialRepository extends JpaRepository<Financial,Long> {
    @Query("select f from Financial f where f.employersName like :kw")
    List<Financial> searchFinancial(@Param("kw") String keyword);
}
