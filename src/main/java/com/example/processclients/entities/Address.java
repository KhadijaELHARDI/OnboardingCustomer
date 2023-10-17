package com.example.processclients.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String addressCountry;
    private String  addressPurpose;
    private Long buildingNo;
    private Long flatNo;
    private String townCity;
    private String subDepartment;
    private Long postCode;
    private Long poBoxNo;
    private String countrySubdivision;
    private String  updatePrevAddress;
    private String language;
    private String addressType;
    private String buildingName;
    private String street;
    private String address;
    private String department;
    private String floor;
    private String  townLocationName;
    private  String districtName;
    private String country;
    private String  addressValidatedBy;
    private String residenceStatus;
    private String residenceType;
    private Date residenceSince;
    private int  residenceValue;
    private float mortgageAmount;
    @ManyToOne
    private Customer customerId;
}
