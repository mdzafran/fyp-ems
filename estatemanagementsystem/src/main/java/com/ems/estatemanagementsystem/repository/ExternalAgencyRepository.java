package com.ems.estatemanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ems.estatemanagementsystem.entity.ExternalAgency;

@Repository
public interface ExternalAgencyRepository extends JpaRepository<ExternalAgency, Long> {
    

}
