package com.ems.estatemanagementsystem.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.ems.estatemanagementsystem.dto.DistrictDTO;
import com.ems.estatemanagementsystem.dto.StateDTO;
import com.ems.estatemanagementsystem.entity.District;
import com.ems.estatemanagementsystem.entity.State;
import com.ems.estatemanagementsystem.service.DistrictService;
import com.ems.estatemanagementsystem.service.StateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class StateDistrictBuilder {
    private final StateService stateService;
    private final DistrictService districtService;

    public StateDistrictBuilder (StateService stateService, DistrictService districtService) {
        this.stateService = stateService;
        this.districtService = districtService;
    }

    @GetMapping("/stateDistrict")
    public String mainStateDistrict(Model model) {
        List<StateDTO> stateList = stateService.getStateList();
        List<DistrictDTO> districtList = districtService.getDistrictList();
        model.addAttribute("stateList", stateList);
        model.addAttribute("districtList", districtList);
        return "stateDistrict";
    }
    

    @GetMapping("/state/add")
    public String addingState(Model model) {
        State state = new State();
        model.addAttribute("state", state);
        return "addState";
    }

    @PostMapping("/state/add/done")
    public String savingState(@ModelAttribute State state, Model model) {
        stateService.saveState(state);
        model.addAttribute("successMessage", "State saved successfully!");
        return "redirect:/stateDistrict";
    }

    @GetMapping("/district/add")
    public String addingDistrict(Model model) {
        District district = new District();
        List<StateDTO> stateList = stateService.getStateList();
        model.addAttribute("stateList", stateList);
        model.addAttribute("district", district);
        return "addDistrict";
    }

    @PostMapping("/district/add/done")
    public String savingDistrict(@ModelAttribute District district, Model model) {
        districtService.saveDistrict(district);
        model.addAttribute("successMessage", "District saved successfully!");
        return "redirect:/stateDistrict";
    }

    @GetMapping("/districts")
    public List<DistrictDTO> getDistrictsByState(@RequestParam Long stateId) {
        State chosenState = stateService.getStateById(stateId);
        if (chosenState == null) {
            return Collections.emptyList();
        }
        return getDistrictsForState(stateId);
    }

    private List<DistrictDTO> getDistrictsForState(Long stateId) {
        return districtService.getDistrictListByState(stateId);
    }

}
