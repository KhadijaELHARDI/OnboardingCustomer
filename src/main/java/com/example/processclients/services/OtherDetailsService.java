package com.example.processclients.services;

import com.example.processclients.dtos.OtherDetailsDTO;
import com.example.processclients.exceptions.OtherDetailsNotFoundException;

import java.util.List;

public interface OtherDetailsService {
    OtherDetailsDTO creer(OtherDetailsDTO otherDetailsDTO);
    OtherDetailsDTO getOtherDetails(Long OtherDetailsId) throws OtherDetailsNotFoundException;
    OtherDetailsDTO updateOtherDetails(OtherDetailsDTO otherDetailsDTO);
    void deleteOtherDetails(Long otherDetailsId);
    List<OtherDetailsDTO> listOtherDetails();
    List<OtherDetailsDTO> searchOtherDetails(String keyword);


}
