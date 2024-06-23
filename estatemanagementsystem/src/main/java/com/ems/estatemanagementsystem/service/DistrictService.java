package com.ems.estatemanagementsystem.service;

import java.util.List;

import com.ems.estatemanagementsystem.dto.DistrictDTO;
import com.ems.estatemanagementsystem.entity.District;

public interface DistrictService {

    District saveDistrict(District district);

    List<DistrictDTO> getDistrictList();

    List<DistrictDTO> getDistrictListByState(Long stateId);
    
}
