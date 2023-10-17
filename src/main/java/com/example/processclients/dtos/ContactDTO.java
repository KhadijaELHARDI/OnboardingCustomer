package com.example.processclients.dtos;

import com.example.processclients.entities.Customer;
import lombok.Data;

@Data
public class ContactDTO {
    private Long id;
    private String phoneRes;
    private String phoneMobile;
    private String email;
    private String phoneOff;
    private String fax;
    private String conType;
    private String conData;
    private String idPrePhone;
    private String audAdd;
    private String secMessage;
    private Long customerId;
}
