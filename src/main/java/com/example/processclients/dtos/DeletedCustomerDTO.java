package com.example.processclients.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class DeletedCustomerDTO {
    private Long id;
    private Date deletionDate;
    private String fullName;
    private String job;
    private Date dateBirth;
    private Long customerId;

}
