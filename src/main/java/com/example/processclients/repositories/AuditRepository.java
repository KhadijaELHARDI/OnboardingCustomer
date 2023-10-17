package com.example.processclients.repositories;

import com.example.processclients.entities.Audit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuditRepository extends JpaRepository<Audit,Long> {
    @Query("select a from Audit a where  a.auditor like :kw")
    List<Audit> searchAudit(@Param("kw") String keyword);
}
