package com.example.processclients.dtos;

import com.example.processclients.entities.Customer;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.util.Date;
@Data
public class KycDTO {
    private Long id;
    private Date contactDate;
    private String KycRelationShip;
    private Date lastKycReviewDate;
    private Date lastSuitReviewDate;
    private String riskAssetType;
    private String amlCheck;
    private Date lastAmlResultDt;
    private String  calcRiskType;
    private Date  AutoNextKycRev;
    private Date AutoNextSuitRev;
    private String  riskLevel;
    private String riskTolerance;
    private Date riskFromDate;
    private String manualRiskClass;
    private String introducer;
    private String  kycComplete;
    private String overrideReason;

    private Long customerId;
}
