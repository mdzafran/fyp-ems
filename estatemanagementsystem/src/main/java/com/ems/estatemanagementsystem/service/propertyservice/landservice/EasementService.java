package com.ems.estatemanagementsystem.service.propertyservice.landservice;

import java.util.List;

import com.ems.estatemanagementsystem.entity.User;
import com.ems.estatemanagementsystem.entity.property.land.Easement;

public interface EasementService {
    List<Easement> getAllEasements();

	List<Easement> getEasementsByUser(User user);

	List<Easement> getEasementsByUserId(Long userId);
	
	Easement saveEasement(Easement easement);
	
	Easement getEasementById(Long id);
	
	Easement updateEasement(Easement easement);
	
	void deleteEasementById(Long id);
}
