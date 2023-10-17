package com.example.processclients.entities;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data
@NoArgsConstructor @AllArgsConstructor

public class Financial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @OneToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Customer customerId;


}
