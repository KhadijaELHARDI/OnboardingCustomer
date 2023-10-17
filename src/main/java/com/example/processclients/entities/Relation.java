package com.example.processclients.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
public class Relation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String  relationCode;

    private String  reserveRelation;
    private  String relationDelvOption;
    private String moreRoleInfo;
    private String  customerLiability;
    private String relationCustomer;
    private String  role;
    private String roleNotes;
    @ManyToOne
    private Customer customerId;

}
