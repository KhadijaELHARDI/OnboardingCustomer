package com.example.processclients.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data
@NoArgsConstructor @AllArgsConstructor

public class Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String  override;
    private String   recordStatus;
    private int currentNumber;
    private String inputter;
    private String authoriser;
    private Date  datetime;
    private int companyCode;
    private int departementcode;
    private String auditor;
    private Date auditdatetime;

    @ManyToOne
    private Customer customerId;

}
