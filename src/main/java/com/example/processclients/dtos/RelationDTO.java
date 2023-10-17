package com.example.processclients.dtos;

import com.example.processclients.entities.Customer;

import lombok.Data;

@Data
public class RelationDTO {
    private Long id;
    private String  relationCode;

    private String  reserveRelation;
    private  String relationDelvOption;
    private String moreRoleInfo;
    private String  customerLiability;
    private String relationCustomer;
    private String  role;
    private String roleNotes;

    private Long customerId;

}
