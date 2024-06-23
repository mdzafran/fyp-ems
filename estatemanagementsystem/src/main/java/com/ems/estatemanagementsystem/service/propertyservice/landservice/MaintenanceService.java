package com.ems.estatemanagementsystem.service.propertyservice.landservice;

import java.util.List;

import com.ems.estatemanagementsystem.entity.User;
import com.ems.estatemanagementsystem.entity.property.land.Maintenance;

public interface MaintenanceService {
    List<Maintenance> getAllMaintenances();

	List<Maintenance> getMaintenancesByUser(User user);

	List<Maintenance> getMaintenancesByUserId(Long userId);
	
	Maintenance saveMaintenance(Maintenance maintenance);
	
	Maintenance getMaintenanceById(Long id);
	
	Maintenance updateMaintenance(Maintenance maintenance);
	
	void deleteMaintenanceById(Long id);
}
