package com.example.processclients.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor


public class DeletedCustomer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Date deletionDate;
    private String fullName;
    private String job;
    private Date dateBirth;


    @OneToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Customer originalCustomer;
    public DeletedCustomer(Date deletionDate, Customer originalCustomer) {
        this.deletionDate = deletionDate;
        this.originalCustomer = originalCustomer;
    }
    public void setOriginalCustomer(Customer originalCustomer) {
        this.originalCustomer = originalCustomer;
    }

}
