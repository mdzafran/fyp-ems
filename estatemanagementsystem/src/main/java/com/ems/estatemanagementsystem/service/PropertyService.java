package com.ems.estatemanagementsystem.service;

import java.util.List;

import com.ems.estatemanagementsystem.entity.Property;
import com.ems.estatemanagementsystem.entity.User;

public interface PropertyService {
    List<Property> getAllProperties();

	List<Property> getPropertiesByUser(User user);

	List<Property> getPropertiesByUserId(Long userId);
	
	Property saveProperty(Property property);
	
	Property getPropertyById(Long id);
	
	Property updateProperty(Property property);
	
	void deletePropertyById(Long id);
}
