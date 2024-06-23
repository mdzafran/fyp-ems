package com.ems.estatemanagementsystem.entity.property.land;

import java.sql.Date;

import com.ems.estatemanagementsystem.entity.Land;

import jakarta.persistence.Entity;
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
@Table(name = "mortgage")
public class Mortgage extends Land{
    private double amount;

    
    private String mortgageeName;

    
    private String mortgageeAddress;

    
    private Date mortgageStartDate;

    
    private Date mortgageEndDate;

}
