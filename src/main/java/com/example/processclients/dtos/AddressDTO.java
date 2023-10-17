package com.example.processclients.dtos;

import com.example.processclients.entities.Customer;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;
@Data
public class AddressDTO {
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

    private Long customerId;
}
