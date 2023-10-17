package com.example.processclients.dtos;


import com.example.processclients.entities.Customer;
import lombok.Data;

import java.util.Date;
@Data
public class CustomerDTO {

     private Long id;
    private String title;
    private String givenName;
    private String fullName;
    private String shortName;
    private String Gender;
    private String accountOfficer;
    private String Sector;
    private String Target;
    private String Nationality;
    private String CustomerType;
    private Date DateOfBirth;
    private String CustBirthProvince;
    private String CustBirthCountry;
    private String Vulnerability;
    private String Salutation;
    private String FamilyName;
    private String Mnemonic;
    private String MaritalStatus;
    private String SecondOfficer;
    private String Industry;
    private String CustomerStatus;
    private String Residence;
    private String CustomerRating;
    private String Language;
    private String CustBirthCity;



}
