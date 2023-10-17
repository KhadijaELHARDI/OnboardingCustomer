package com.example.processclients.services;

import com.example.processclients.dtos.DocumentDTO;
import com.example.processclients.dtos.FurtherDetailsDTO;
import com.example.processclients.exceptions.DocumentNotFoundException;
import com.example.processclients.exceptions.FurtherDetailsNotFoundException;

import java.util.List;

public interface FurtherDetailsService {
    FurtherDetailsDTO creer(FurtherDetailsDTO furtherDetailsDTO);
    FurtherDetailsDTO getFurtherDetails(Long furtherDetailsId) throws FurtherDetailsNotFoundException;
    FurtherDetailsDTO updateFurtherDetails(FurtherDetailsDTO furtherDetailsDTO);
    void deleteFurtherDetails(Long furtherDetailsId);
    List<FurtherDetailsDTO> listFurtherDetails();
    List<FurtherDetailsDTO> searchFurtherDetails(String keyword);
}
