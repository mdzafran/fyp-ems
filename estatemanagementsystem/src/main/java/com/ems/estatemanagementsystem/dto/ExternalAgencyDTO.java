package com.ems.estatemanagementsystem.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExternalAgencyDTO {

    private Long id;
    private String agencyName;

    @NotEmpty(message = "Email should not be empty")
    @Email
    private String email;

    private String phoneNum;

    private String address;

    @Size(min = 5, max = 5, message = "Postcode must be exactly 5 characters")
    private String postcode;

    private String state;

    private String district;

    private float serviceFee;
}
