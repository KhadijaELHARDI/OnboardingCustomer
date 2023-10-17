package com.example.processclients.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String phoneRes;
    private String  phoneMobile;
    private String  email;
    private String phoneOff;
    private String fax;
    private String conType;
    private String conData;
    private String idPrePhone;
    private String audAdd;
    private String secMessage;
    @OneToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Customer customerId;

}
