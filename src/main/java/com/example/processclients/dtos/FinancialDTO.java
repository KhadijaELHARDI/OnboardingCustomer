package com.example.processclients.dtos;

import com.example.processclients.entities.Customer;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.util.Date;
@Data
public class FinancialDTO {
    private Long id;
    private String employmentStatus;
    private String jobTitle;
    private String employersAddress;
    private String  employersBusiness;
    private String customerCurrency;
    private int annualBonus;
    private int netMonthlyIn;
    private String occupation;
    private String employersName;
    private Date employmentStartDt;
    private float customerSalary;
    private Date  salaryDateFrequency;
    private int netMonthlyOut;
    private long customerId;

}
