package com.ems.estatemanagementsystem.service.propertyservice.landservice;

import java.util.List;

import com.ems.estatemanagementsystem.entity.User;
import com.ems.estatemanagementsystem.entity.property.land.Tenancy;

public interface TenancyService {
    List<Tenancy> getAllTenancies();

	List<Tenancy> getTenanciesByUser(User user);

	List<Tenancy> getTenanciesByUserId(Long userId);
	
	Tenancy saveTenancy(Tenancy tenancy);
	
	Tenancy getTenancyById(Long id);
	
	Tenancy updateTenancy(Tenancy tenancyenancy);
	
	void deleteTenancyById(Long id);
}
