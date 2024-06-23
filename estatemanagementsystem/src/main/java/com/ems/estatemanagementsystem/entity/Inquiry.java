package com.ems.estatemanagementsystem.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
@Table(name="inquiry")
public class Inquiry {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date inquiryDate;

    @Column(nullable = false)
    private String inquiryFor;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "inquiry_external_agency",
        joinColumns = @JoinColumn(name = "inquiry_id"),
        inverseJoinColumns = @JoinColumn(name = "agency_id")
    )
    private List<ExternalAgency> inquiryAgency;

    private List<String> inquiryAgencyStatus;

    @Column(nullable = false)
    private Boolean agreement;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @Column(name = "ic_file_path", nullable = false)
    private String icFilePath;

    @Column(name = "death_cert_path", nullable = false)
    private String deathCertPath;

    @Column(name = "status")
    private String status;

    @Column(name = "totalPayment", nullable = true)
    private Float totalPayment;

}
