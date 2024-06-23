package com.ems.estatemanagementsystem.entity.property.land;

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
@Table(name = "maintenance")
public class Maintenance extends Land{

    private double current;

    private double outstanding;

}
