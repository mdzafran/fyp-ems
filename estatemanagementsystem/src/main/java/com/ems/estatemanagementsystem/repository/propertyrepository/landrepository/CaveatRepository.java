package com.ems.estatemanagementsystem.repository.propertyrepository.landrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ems.estatemanagementsystem.entity.User;
import com.ems.estatemanagementsystem.entity.property.land.Caveat;



@Repository
public interface CaveatRepository extends JpaRepository<Caveat, Long>{
    List<Caveat> findByUser(User user);

    List<Caveat> findByUserId(Long userId);
}
