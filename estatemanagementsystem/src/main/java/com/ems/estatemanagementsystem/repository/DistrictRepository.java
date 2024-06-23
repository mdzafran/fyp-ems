package com.ems.estatemanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ems.estatemanagementsystem.entity.District;
import com.ems.estatemanagementsystem.entity.State;

@Repository
public interface DistrictRepository extends JpaRepository<District, Long>{

    List<District> findByStateInfo(State state);
    
}
