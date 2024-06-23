package com.ems.estatemanagementsystem.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="external_agency")
public class ExternalAgency {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String agencyName;

    @Column(nullable=false)
    private String email;

    @Column(nullable=false)
    private String phoneNum;

    @Column(nullable=false)
    private String address;

    @Column(nullable=false)
    private String postcode;

    @Column(nullable=false)
    private String district;

    @Column(nullable=false)
    private String state;

    @OneToMany(mappedBy = "externalAgencyInfo")
    private List<PIC> pics;

    @Column(nullable=true)
    private float serviceFee;
}


