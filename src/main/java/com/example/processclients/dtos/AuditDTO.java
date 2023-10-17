package com.example.processclients.dtos;

import com.example.processclients.entities.Customer;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;
@Data
public class AuditDTO {
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
    private Long customerId;

}
