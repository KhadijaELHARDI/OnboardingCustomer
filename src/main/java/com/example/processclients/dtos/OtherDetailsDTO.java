package com.example.processclients.dtos;

import com.example.processclients.entities.Customer;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.util.Date;
@Data
public class OtherDetailsDTO {
    private Long id;
    private String branchName;
    private String issueCheque;
    private String visibilityType;
    private String visComment;
    private String previousVisibilityType;
    private String CrmUpdate;
    private int taxId;
    private String crProType;
    private String  crProfile;
    private String bpRequired;
    private String visReview;
    private String holPivot;
    private String exStatus;
    private String exReason;

    private Long customerId;
}
