package com.ems.estatemanagementsystem.service.propertyservice.landservice;

import java.util.List;

import com.ems.estatemanagementsystem.entity.User;
import com.ems.estatemanagementsystem.entity.property.land.UtilitiesBill;

public interface UtilitiesBillService {
    List<UtilitiesBill> getAllUtilitiesBills();

	List<UtilitiesBill> getUtilitiesBillsByUser(User user);

	List<UtilitiesBill> getUtilitiesBillsByUserId(Long userId);
	
	UtilitiesBill saveUtilitiesBill(UtilitiesBill utilitiesBill);
	
	UtilitiesBill getUtilitiesBillById(Long id);
	
	UtilitiesBill updateUtilitiesBill(UtilitiesBill utilitiesBill);
	
	void deleteUtilitiesBillById(Long id);
}
