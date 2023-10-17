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
public class FurtherDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String previousName;
    private Date changeDate;
    private Date customerSince;
    private String otherNationality;
    private String interests;
    private String furtherDetails;
    private String pastimes;
    private int noOfDependents;
    private String spokenLanguages;
    private String  commType;
    private String confidential;
    private String internetBanking;
    private String  prefChannel;
    private String mobileBanking;
    @OneToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Customer customerId;

}
