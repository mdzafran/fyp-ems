package com.ems.estatemanagementsystem.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ems.estatemanagementsystem.dto.StateDTO;
import com.ems.estatemanagementsystem.entity.State;
import com.ems.estatemanagementsystem.repository.StateRepository;
import com.ems.estatemanagementsystem.service.StateService;

@Service
public class StateServiceImpl implements StateService{
    
    private final StateRepository stateRepository;

    public StateServiceImpl (StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @Override
    public State saveState(State state) {
        return stateRepository.save(state);
    }

    @Override
    public List<StateDTO> getStateList() {
        List<State> stateList = stateRepository.findAll();
        return stateList.stream().map((state) -> convertEntityToDto(state))
                .collect(Collectors.toList());
    }

    private StateDTO convertEntityToDto(State state) {
        StateDTO stateDTO = new StateDTO();
        stateDTO.setId(state.getId());
        stateDTO.setStateName(state.getStateName());
        return stateDTO;
    }

    @Override
    public State getStateById(Long stateId) {
        Optional<State> tempState = stateRepository.findById(stateId);
        State state = new State();
        if(tempState.isPresent()) {
            List<State> stateList = stateRepository.findAll();

            for (State selectedState : stateList) {
                if (selectedState.getId() == stateId) {
                    state = selectedState;
                    break;
                }
            }
        }
        return state;
    }
}
