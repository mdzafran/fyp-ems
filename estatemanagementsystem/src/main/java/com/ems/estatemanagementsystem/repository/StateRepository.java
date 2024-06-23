package com.ems.estatemanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ems.estatemanagementsystem.entity.State;

@Repository
public interface StateRepository extends JpaRepository<State, Long>{
    
}
