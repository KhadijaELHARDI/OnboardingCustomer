package com.example.processclients.dtos;

import com.example.processclients.entities.Customer;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.util.Date;
@Data
public class FurtherDetailsDTO {
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

    private Long customerId;

}
