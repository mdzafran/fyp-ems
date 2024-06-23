package com.ems.estatemanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ems.estatemanagementsystem.entity.Land;
import com.ems.estatemanagementsystem.entity.User;

import java.util.List;

@Repository
public interface LandRepository extends JpaRepository<Land, Long>{
    
    List<Land> findByUser(User user);

    List<Land> findByUserId(Long userId);

    Land findByTitleId(String titleId);
}
