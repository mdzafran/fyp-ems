package com.ems.estatemanagementsystem.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ems.estatemanagementsystem.dto.ExternalAgencyDTO;
import com.ems.estatemanagementsystem.entity.ExternalAgency;
import com.ems.estatemanagementsystem.repository.ExternalAgencyRepository;
import com.ems.estatemanagementsystem.service.ExternalAgencyService;

@Service
public class ExternalAgencyServiceImpl implements ExternalAgencyService{
    
    private ExternalAgencyRepository externalAgencyRepository;

    public ExternalAgencyServiceImpl (ExternalAgencyRepository externalAgencyRepository) {
        this.externalAgencyRepository = externalAgencyRepository;
    }

    @Override
    public ExternalAgency saveExternalAgency(ExternalAgency externalAgency){
        return externalAgencyRepository.save(externalAgency);
    }

    @Override
    public List<ExternalAgencyDTO> getExternalAgencyList() {
        List<ExternalAgency> externalAgencyList = externalAgencyRepository.findAll();
        return externalAgencyList.stream().map((externalAgency) -> convertEntityToDto(externalAgency))
                .collect(Collectors.toList());
    }

    private ExternalAgencyDTO convertEntityToDto(ExternalAgency externalAgency) {
        ExternalAgencyDTO externalAgencyDTO = new ExternalAgencyDTO();
        externalAgencyDTO.setId(externalAgency.getId());
        externalAgencyDTO.setAgencyName(externalAgency.getAgencyName());
        externalAgencyDTO.setEmail(externalAgency.getEmail());
        externalAgencyDTO.setAddress(externalAgency.getAddress());
        externalAgencyDTO.setPostcode(externalAgency.getPostcode());
        externalAgencyDTO.setState(externalAgency.getState());
        externalAgencyDTO.setDistrict(externalAgency.getDistrict());
        externalAgencyDTO.setPhoneNum(externalAgency.getPhoneNum());
        externalAgencyDTO.setServiceFee(externalAgency.getServiceFee());
        return externalAgencyDTO;
    }

    @Override
    public ExternalAgency getExternalAgencyById(Long externalAgencyId) {
        Optional<ExternalAgency> chosenExternalAgency = externalAgencyRepository.findById(externalAgencyId);

        if(chosenExternalAgency.isPresent()) {
            ExternalAgency currentExternalAgency = chosenExternalAgency.get();
            return currentExternalAgency;
        } else {
            return null;
        }
    }

    @Override
    public ExternalAgency updateExternalAgency(ExternalAgency externalAgency) {
        ExternalAgency existingExternalAgency = getExternalAgencyById(externalAgency.getId());

        existingExternalAgency.setId(externalAgency.getId());
        existingExternalAgency.setAgencyName(externalAgency.getAgencyName());
        existingExternalAgency.setEmail(externalAgency.getEmail());
        existingExternalAgency.setAddress(externalAgency.getAddress());
        existingExternalAgency.setPostcode(externalAgency.getPostcode());
        existingExternalAgency.setState(externalAgency.getState());
        existingExternalAgency.setPhoneNum(externalAgency.getPhoneNum());
        existingExternalAgency.setServiceFee(externalAgency.getServiceFee());
        
        return externalAgencyRepository.save(existingExternalAgency);
    }

    @Override
    public void deleteExternalAgencyById(Long externalAgencyId){
        externalAgencyRepository.deleteById(externalAgencyId);
    }
}
