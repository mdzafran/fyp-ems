package com.ems.estatemanagementsystem.service;

import java.util.List;

import com.ems.estatemanagementsystem.entity.Land;
import com.ems.estatemanagementsystem.entity.User;

public interface LandService {
    List<Land> getAllLands();

    List<Land> getLandsByUser(User user);

    List<Land> getLandsByUserId(Long userId);

    Land saveLand(Land land);

    Land getLandById(Long id);

    Land updateLand(Land land);

    void deleteLandById(Long id);

    Land getLandByTitleId(String titleId);
}
