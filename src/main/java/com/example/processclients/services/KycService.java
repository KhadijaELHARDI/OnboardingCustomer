package com.example.processclients.services;

import com.example.processclients.dtos.FurtherDetailsDTO;
import com.example.processclients.dtos.KycDTO;
import com.example.processclients.exceptions.FurtherDetailsNotFoundException;
import com.example.processclients.exceptions.KycNotFoundException;

import java.util.List;

public interface KycService {
    KycDTO creer(KycDTO kycDTO);
    KycDTO getKyc(Long kycId) throws KycNotFoundException;
    KycDTO updatekyc(KycDTO kycDTO);
    void deleteKyc(Long kycId);
    List<KycDTO> listKyc();
    List<KycDTO> searchKyc(String keyword);
}
