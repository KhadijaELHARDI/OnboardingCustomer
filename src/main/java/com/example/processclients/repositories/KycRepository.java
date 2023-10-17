package com.example.processclients.repositories;

import com.example.processclients.entities.Kyc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface KycRepository extends JpaRepository<Kyc,Long> {
    @Query("select k from Kyc k where k.kycRelationShip like :kw")
    List<Kyc> searchKyc(@Param("kw") String keyword);
}
