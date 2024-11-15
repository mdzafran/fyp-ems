package com.ems.estatemanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ems.estatemanagementsystem.entity.Inquiry;

@Repository
public interface InquiryRepository extends JpaRepository<Inquiry, Long>{
 
}
