package com.ems.estatemanagementsystem.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ems.estatemanagementsystem.dto.DistrictDTO;
import com.ems.estatemanagementsystem.dto.ExternalAgencyDTO;
import com.ems.estatemanagementsystem.dto.PICDTO;
import com.ems.estatemanagementsystem.dto.StateDTO;
import com.ems.estatemanagementsystem.entity.ExternalAgency;
import com.ems.estatemanagementsystem.service.DistrictService;
import com.ems.estatemanagementsystem.service.ExternalAgencyService;
import com.ems.estatemanagementsystem.service.PICService;
import com.ems.estatemanagementsystem.service.StateService;


@Controller
public class ExternalAgencyController {

    private final ExternalAgencyService externalAgencyService;
    private final StateService stateService;
    private final DistrictService districtService;
    private final PICService picService;


    public ExternalAgencyController(ExternalAgencyService externalAgencyService, StateService stateService, DistrictService districtService, PICService picService) {
        this.externalAgencyService = externalAgencyService;
        this.stateService = stateService;
        this.districtService = districtService;
        this.picService = picService;
    }
    
    @GetMapping("/admin/externalAgency/add/")
    public String addingExternalAgency(Model model) {
        ExternalAgency externalAgency = new ExternalAgency();
        List<StateDTO> stateList = stateService.getStateList();
        List<DistrictDTO> districtList = districtService.getDistrictList();
        model.addAttribute("stateList", stateList);
        model.addAttribute("districtList", districtList);
        model.addAttribute("externalAgency", externalAgency);
        return "addExternalAgency";
    }

    @PostMapping("/admin/externalAgency/add/done")
    public String savingExternalAgency(@ModelAttribute ExternalAgency agency, Model model) {
        externalAgencyService.saveExternalAgency(agency);
        model.addAttribute("successMessage", "External Agency saved successfully!");
        return "redirect:/admin/externalAgency/list/";
    }
    
    @GetMapping("/admin/externalAgency/list/")
    public String listWasiat(Model model) {
        List<ExternalAgencyDTO> externalAgencyList = externalAgencyService.getExternalAgencyList();
        List<PICDTO> picList = picService.findAll();
        model.addAttribute("externalAgencyList", externalAgencyList);
        model.addAttribute("picList", picList);
        return "externalAgencyViewList";
    }

    @GetMapping("/admin/externalAgency/view/{externalAgencyId}")
    public String viewExternalAgency(@PathVariable Long externalAgencyId, Model model) {
        ExternalAgency externalAgency = externalAgencyService.getExternalAgencyById(externalAgencyId);

        model.addAttribute("externalAgencyId", externalAgencyId);
        model.addAttribute("externalAgencyShow", externalAgency);

        if (externalAgencyId == null) {
            // Redirect to the error page if externalAgencyId are empty
            return "redirect:/error";
        }

        return "viewExternalAgency";
    }

    @GetMapping("/admin/externalAgency/update/{externalAgencyId}")
    public String updateExternalAgency(@PathVariable Long externalAgencyId, Model model) {
        
        ExternalAgency externalAgency = externalAgencyService.getExternalAgencyById(externalAgencyId);
        List<StateDTO> stateList = stateService.getStateList();
        List<DistrictDTO> districtList = districtService.getDistrictList();
        model.addAttribute("stateList", stateList);
        model.addAttribute("districtList", districtList);
        model.addAttribute("externalAgency", externalAgency);
        model.addAttribute("externalAgencyId", externalAgencyId);
        return "updateExternalAgency";

    }

    @PostMapping("/admin/externalAgency/save/")
    public String saveExternalAgencyUpdate(@ModelAttribute ExternalAgency externalAgency, Model model){

        externalAgencyService.updateExternalAgency(externalAgency);
        
        model.addAttribute("successMessage", "External agency saved successfully!");

        return "redirect:/admin/externalAgency/list/";
    }

    @GetMapping("/admin/externalAgency/delete/{externalAgencyId}")
    public String deleteExternalAgency(@PathVariable Long externalAgencyId, Model model) {
        externalAgencyService.deleteExternalAgencyById(externalAgencyId);
		return "redirect:/admin/externalAgency/list/";
    }
}
