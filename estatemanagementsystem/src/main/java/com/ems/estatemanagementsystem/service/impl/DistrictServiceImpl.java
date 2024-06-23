package com.ems.estatemanagementsystem.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ems.estatemanagementsystem.dto.DistrictDTO;
import com.ems.estatemanagementsystem.entity.District;
import com.ems.estatemanagementsystem.entity.State;
import com.ems.estatemanagementsystem.repository.DistrictRepository;
import com.ems.estatemanagementsystem.repository.StateRepository;
import com.ems.estatemanagementsystem.service.DistrictService;

@Service
public class DistrictServiceImpl implements DistrictService{

    private DistrictRepository districtRepository;
    private StateRepository stateRepository;

    public DistrictServiceImpl (DistrictRepository districtRepository, StateRepository stateRepository) {
        this.districtRepository = districtRepository;
        this.stateRepository = stateRepository;
    }

    @Override
    public District saveDistrict (District district) {
        return districtRepository.save(district);
    }

    @Override
    public List<DistrictDTO> getDistrictList() {
        List<District> districtList = districtRepository.findAll();
        return districtList.stream().map((district) -> convertEntityToDto(district))
                .collect(Collectors.toList());
    }

    private DistrictDTO convertEntityToDto(District district) {
        DistrictDTO districtDTO = new DistrictDTO();
        districtDTO.setId(district.getId());
        districtDTO.setDistrictName(district.getDistrictName());
        if (district.getStateInfo() != null && district.getStateInfo().getStateName() != null) {
            districtDTO.setStateName(district.getStateInfo().getStateName());
        }
        return districtDTO;
    }

    @Override
    public List<DistrictDTO> getDistrictListByState(Long stateId) {
        // Fetch the state object from the database using the stateId
        State state = stateRepository.findById(stateId).orElse(null);
        if (state == null) {
            // Handle the case where the state with the given ID does not exist
            return Collections.emptyList();
        }

        // Fetch districts for the given state
        List<District> districtList = districtRepository.findByStateInfo(state);

        // Convert District entities to DTOs
        return districtList.stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }
    
}
