package com.ems.estatemanagementsystem.service;

import com.ems.estatemanagementsystem.dto.InquiryDTO;
import com.ems.estatemanagementsystem.entity.Inquiry;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface InquiryService {
    Inquiry createInquiry(Inquiry inquiry, List<Long> agencyIds, MultipartFile icFile, MultipartFile deathCert) throws IOException;

    List<InquiryDTO> getInquiryList();

    InquiryDTO findInquiryById(Long id);

    Inquiry updateInquiry(Inquiry inquiry);

    Inquiry getInquiryById(Long inquiryId);

    Inquiry findInquiryNotDTOById(Long inquiryId);

}

public void saveInquiry(InquiryDTO inquiryDTO) {
    Inquiry inquiry = new Inquiry();
    inquiry.setDetails(inquiryDTO.getDetails());
    // Set other details from DTO
    inquiryRepository.save(inquiry);  // Save to the database
}

public List<Inquiry> findAllInquiriesForPewaris() {
    return inquiryRepository.findAllByUserRole("ROLE PEWARIS");  // Assuming Inquiry entity has a User relation
}

public void updateInquiryStatus(Long id, String status) {
    Inquiry inquiry = inquiryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid inquiry Id:" + id));
    inquiry.setStatus(status);
    inquiryRepository.save(inquiry);
}
