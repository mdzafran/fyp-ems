package com.ems.estatemanagementsystem.service.propertyservice.landservice;

import java.util.List;

import com.ems.estatemanagementsystem.entity.User;
import com.ems.estatemanagementsystem.entity.property.land.Caveat;

public interface CaveatService {
    List<Caveat> getAllCaveats();

	List<Caveat> getCaveatsByUser(User user);

	List<Caveat> getCaveatsByUserId(Long userId);
	
	Caveat saveCaveat(Caveat caveat);
	
	Caveat getCaveatById(Long id);
	
	Caveat updateCaveat(Caveat caveat);
	
	void deleteCaveatById(Long id);
}
