package com.example.processclients.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long legalId;
    private String nameOnId;
    private Date issueDate;
    private String issueCountry;
    private String documentName;
    private String issueAuthority;
    private Date expirationDate;
    @ManyToOne
    private Customer customerId;

}
