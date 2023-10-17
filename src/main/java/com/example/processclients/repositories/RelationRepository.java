package com.example.processclients.repositories;

import com.example.processclients.entities.Relation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RelationRepository extends JpaRepository<Relation,Long> {
    @Query("select r from  Relation  r where r.relationCustomer like :kw")
    List<Relation> searchRelation(@Param("kw") String keyword);
}
