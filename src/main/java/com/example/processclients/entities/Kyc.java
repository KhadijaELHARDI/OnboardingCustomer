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

public class Kyc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date contactDate;
    private String kycRelationShip;
    private Date lastKycReviewDate;
    private Date lastSuitReviewDate;
    private String riskAssetType;
    private String amlCheck;
    private Date lastAmlResultDt;
    private String  calcRiskType;
    private Date  autoNextKycRev;
    private Date autoNextSuitRev;
    private String  riskLevel;
    private String riskTolerance;
    private Date riskFromDate;
    private String manualRiskClass;
    private String introducer;
    private String  kycComplete;
    private String overrideReason;
    @OneToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Customer customerId;

}
