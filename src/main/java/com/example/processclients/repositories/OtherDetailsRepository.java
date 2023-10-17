package com.example.processclients.repositories;

import com.example.processclients.entities.OtherDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OtherDetailsRepository extends JpaRepository<OtherDetails,Long> {
    @Query("select  o from OtherDetails  o where  o.branchName like :kw")
    List<OtherDetails>searchOtherDetails (@Param("kw") String keyword);
}
