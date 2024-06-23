package com.ems.estatemanagementsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.estatemanagementsystem.entity.Property;
import com.ems.estatemanagementsystem.entity.User;
import com.ems.estatemanagementsystem.repository.PropertyRepository;
import com.ems.estatemanagementsystem.service.PropertyService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PropertyServiceImpl implements PropertyService{

    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    public List<Property> getAllProperties(){
        return propertyRepository.findAll();
    }

    @Override
    public List<Property> getPropertiesByUser(User user){
        return propertyRepository.findByUser(user);
    }

    @Override
    public List<Property> getPropertiesByUserId(Long userId){
        return propertyRepository.findByUserId(userId);
    }

    @Override
    public Property saveProperty(Property property){
        return propertyRepository.save(property);
    }

    @Override
    public Property getPropertyById(Long id) {
        return propertyRepository.findById(id).get();
    }

    @Override
    public Property updateProperty(Property property){
        return propertyRepository.save(property);
    }

    @Override
    public void deletePropertyById(Long id){
        propertyRepository.deleteById(id);
    }
}
