package com.ems.estatemanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ems.estatemanagementsystem.entity.PIC;

@Repository
public interface PICRepository extends JpaRepository<PIC, Long> {
    

}
