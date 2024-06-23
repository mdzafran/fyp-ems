package com.ems.estatemanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ems.estatemanagementsystem.entity.ExternalAgency;
import com.ems.estatemanagementsystem.entity.PIC;
import com.ems.estatemanagementsystem.service.ExternalAgencyService;
import com.ems.estatemanagementsystem.service.PICService;



@Controller
public class PICBuilder {
    private final PICService picService;
    private final ExternalAgencyService externalAgencyService;

    public PICBuilder (PICService picService, ExternalAgencyService externalAgencyService) {
        this.picService = picService;
        this.externalAgencyService = externalAgencyService;
    }

    @GetMapping("/admin/pic/add/{externalAgencyId}")
    public String addingPIC(@PathVariable Long externalAgencyId, Model model) {
        ExternalAgency externalAgency = externalAgencyService.getExternalAgencyById(externalAgencyId);
        PIC pic = new PIC();
        pic.setExternalAgencyInfo(externalAgency);
        model.addAttribute("pic", pic);
        model.addAttribute("externalAgency", externalAgency);
        return "addPIC";
    }

    @PostMapping("/admin/pic/add/{externalAgencyId}/done")
    public String savingPIC(@PathVariable Long externalAgencyId, @ModelAttribute PIC pic, Model model) {
        ExternalAgency externalAgency = externalAgencyService.getExternalAgencyById(externalAgencyId);
        PIC storedPIC = new PIC();
        storedPIC.setPicName(pic.getPicName());
        storedPIC.setPicPhoneNum(pic.getPicPhoneNum());
        storedPIC.setPicEmail(pic.getPicEmail());
        storedPIC.setExternalAgencyInfo(externalAgency);
        picService.savePIC(storedPIC);
        model.addAttribute("successMessage", "PIC saved successfully!");
        return "redirect:/externalAgency/list/";
    }
}
