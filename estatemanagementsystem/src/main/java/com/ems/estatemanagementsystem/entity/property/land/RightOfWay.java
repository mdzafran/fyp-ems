package com.ems.estatemanagementsystem.entity.property.land;

import com.ems.estatemanagementsystem.entity.Land;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "rightofway")
public class RightOfWay extends Land{
}
