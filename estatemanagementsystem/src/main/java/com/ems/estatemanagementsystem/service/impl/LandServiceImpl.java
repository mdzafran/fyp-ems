package com.ems.estatemanagementsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.estatemanagementsystem.entity.Land;
import com.ems.estatemanagementsystem.entity.User;
import com.ems.estatemanagementsystem.repository.LandRepository;
import com.ems.estatemanagementsystem.service.LandService;

@Service
public class LandServiceImpl implements LandService{
    @Autowired
    private LandRepository landRepository;

    @Override
    public List<Land> getAllLands(){
        return landRepository.findAll();
    }

    @Override
    public List<Land> getLandsByUser(User user){
        return landRepository.findByUser(user);
    }

    @Override
    public List<Land> getLandsByUserId(Long userId){
        return landRepository.findByUserId(userId);
    }

    @Override
    public Land saveLand(Land land){
        return landRepository.save(land);
    }

    @Override
    public Land getLandById(Long id){
        return landRepository.findById(id).get();
    }

    @Override
    public Land updateLand(Land land){
        return landRepository.save(land);
    }

    @Override
    public void deleteLandById(Long id){
        landRepository.deleteById(id);
    }

    @Override
    public Land getLandByTitleId(String titleId){
        return landRepository.findByTitleId(titleId);
    }
}
