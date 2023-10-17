package com.example.processclients.repositories;

import com.example.processclients.entities.FurtherDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FurtherDetailsRepository extends JpaRepository<FurtherDetails,Long> {
    @Query("select fd from FurtherDetails fd where fd.mobileBanking like :kw")
    List<FurtherDetails> searchFurtherDetails(@Param("kw") String keyword);
}
