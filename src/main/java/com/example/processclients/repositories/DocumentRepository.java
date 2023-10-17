package com.example.processclients.repositories;

import com.example.processclients.entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DocumentRepository extends JpaRepository<Document,Long> {
    @Query("select d from Document d where d.documentName like :kw")
    List<Document> searchDocument (@Param("kw") String keyword);
}
