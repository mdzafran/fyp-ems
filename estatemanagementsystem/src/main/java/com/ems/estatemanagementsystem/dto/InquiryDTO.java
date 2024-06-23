package com.ems.estatemanagementsystem.dto;

import java.util.Date;
import java.util.List;

import com.ems.estatemanagementsystem.entity.ExternalAgency;
import com.ems.estatemanagementsystem.entity.User;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InquiryDTO {
    
    private Long id;
    private User user;

    @NotEmpty(message = "Content should not be empty")

    private Date inquiryDate;
    private String inquiryFor;
    private List<ExternalAgency> inquiryAgency;
    private List<String> inquiryAgencyStatus;
    private Boolean agreement;
    private String icFilePath;
    private String deathCertPath;
    private String status;
    private float totalPayment;

}
