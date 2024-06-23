package com.ems.estatemanagementsystem.service;

import java.util.List;

import com.ems.estatemanagementsystem.dto.ExternalAgencyDTO;
import com.ems.estatemanagementsystem.entity.ExternalAgency;

public interface ExternalAgencyService {
    ExternalAgency saveExternalAgency(ExternalAgency externalAgency);

    List<ExternalAgencyDTO> getExternalAgencyList();

    ExternalAgency getExternalAgencyById(Long externalAgencyId);

    void deleteExternalAgencyById(Long externalAgencyId);

    ExternalAgency updateExternalAgency(ExternalAgency externalAgency);

    // void saveNewPIC(PIC pic, ExternalAgency externalAgency);
    
} 
