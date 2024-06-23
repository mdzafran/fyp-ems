package com.ems.estatemanagementsystem.service;

import java.util.List;

import com.ems.estatemanagementsystem.dto.StateDTO;
import com.ems.estatemanagementsystem.entity.State;

public interface StateService {

    State saveState(State state);

    List<StateDTO> getStateList();

    State getStateById(Long stateId);
    
}
