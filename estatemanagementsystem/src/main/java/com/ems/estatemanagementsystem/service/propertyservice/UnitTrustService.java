package com.ems.estatemanagementsystem.service.propertyservice;

import java.util.List;

import com.ems.estatemanagementsystem.entity.User;
import com.ems.estatemanagementsystem.entity.property.UnitTrust;

public interface UnitTrustService {
    List<UnitTrust> getAllUnitTrusts();

	List<UnitTrust> getUnitTrustsByUser(User user);

	List<UnitTrust> getUnitTrustsByUserId(Long userId);
	
	UnitTrust saveUnitTrust(UnitTrust unitTrust);
	
	UnitTrust getUnitTrustById(Long id);
	
	UnitTrust updateUnitTrust(UnitTrust unitTrust);
	
	void deleteUnitTrustById(Long id);
}
