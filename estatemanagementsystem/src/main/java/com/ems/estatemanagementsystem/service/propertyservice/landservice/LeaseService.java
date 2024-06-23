package com.ems.estatemanagementsystem.service.propertyservice.landservice;

import java.util.List;

import com.ems.estatemanagementsystem.entity.User;
import com.ems.estatemanagementsystem.entity.property.land.Lease;

public interface LeaseService {
    List<Lease> getAllLeases();

	List<Lease> getLeasesByUser(User user);

	List<Lease> getLeasesByUserId(Long userId);
	
	Lease saveLease(Lease lease);
	
	Lease getLeaseById(Long id);
	
	Lease updateLease(Lease lease);
	
	void deleteLeaseById(Long id);
}
