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
