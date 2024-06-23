package com.ems.estatemanagementsystem.dto;

import com.ems.estatemanagementsystem.entity.ExternalAgency;

// import jakarta.validation.constraints.Email;
// import jakarta.validation.constraints.NotEmpty;
// import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PICDTO {
    private Long id;
    private String picName;
    private String picPhoneNum;
    private String picEmail;
    private ExternalAgency externalAgencyInfo;
}
