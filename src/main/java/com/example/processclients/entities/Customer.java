package com.example.processclients.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String givenName;
    private String fullName;
    private String shortName;
    private String gender;
    private String accountOfficer;
    private String sector;
    private String target;
    private String nationality;
    private String customerType;
    private Date dateOfBirth;
    private String custBirthProvince;
    private String custBirthCountry;
    private String vulnerability;
    private String salutation;
    private String familyName;
    private String mnemonic;
    private String maritalStatus;
    private String secondOfficer;
    private String industry;
    private String customerStatus;
    private String residence;
    private String customerRating;
    private String language;
    private String custBirthCity;
    @OneToMany(mappedBy = "customerId",cascade = CascadeType.ALL)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Relation> relations;
    @OneToMany(mappedBy = "customerId",cascade = CascadeType.ALL)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Document> documents;
    @OneToMany(mappedBy = "customerId",cascade = CascadeType.ALL)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Address> addresses;
    @OneToOne(mappedBy = "customerId",cascade = CascadeType.ALL)
    private Financial financial;
    @OneToOne(mappedBy = "customerId",cascade = CascadeType.ALL)
    private Kyc kyc;
    @OneToOne(mappedBy = "customerId",cascade = CascadeType.ALL)
    private OtherDetails otherDetails;
    @OneToMany(mappedBy = "customerId",cascade = CascadeType.ALL)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Audit> audits;
    @OneToOne(mappedBy = "customerId",cascade = CascadeType.ALL)
    private Contact contact;
    @OneToOne(mappedBy = "customerId",cascade = CascadeType.ALL)
    private FurtherDetails furtherDetails;
    @OneToOne(mappedBy = "originalCustomer")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private DeletedCustomer historiqueCustomer;




}







