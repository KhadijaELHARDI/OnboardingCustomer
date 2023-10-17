package com.example.processclients.dtos;

import com.example.processclients.entities.Customer;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;
@Data
public class DocumentDTO {
    private Long id;
    private Long legalId;
    private String nameOnId;
    private Date issueDate;
    private String issueCountry;
    private String documentName;
    private String issueAuthority;
    private Date expirationDate;

    private Long customerId;
}
