package com.example.processclients.services.impl;

import com.example.processclients.dtos.KycDTO;
import com.example.processclients.entities.Customer;
import com.example.processclients.entities.Kyc;
import com.example.processclients.exceptions.KycNotFoundException;
import com.example.processclients.mappers.CustomerMapperImp;
import com.example.processclients.repositories.CustomerRepository;
import com.example.processclients.repositories.KycRepository;
import com.example.processclients.services.KycService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class KycServiceImp implements KycService {
    private KycRepository kycRepository;
    private CustomerMapperImp dtoMapper;
    private CustomerRepository customerRepository;

    @Override
    public KycDTO creer(KycDTO kycDTO) {
        log.info("Saving new Kyc");
        Kyc kyc=new Kyc();
        Customer customer=customerRepository.findById(kycDTO.getCustomerId()).orElse(null);
        if(customer!=null){
            kyc.setCustomerId(customer);
            kyc.setAutoNextKycRev(kycDTO.getAutoNextKycRev());
            kyc.setAutoNextSuitRev(kycDTO.getAutoNextSuitRev());
            kyc.setKycRelationShip(kycDTO.getKycRelationShip());
            kyc.setAmlCheck(kycDTO.getAmlCheck());
            kyc.setCalcRiskType(kycDTO.getCalcRiskType());
            kyc.setContactDate(kycDTO.getContactDate());
            kyc.setIntroducer(kycDTO.getIntroducer());
            kyc.setKycComplete(kycDTO.getKycComplete());
            kyc.setLastAmlResultDt(kycDTO.getLastAmlResultDt());
            kyc.setLastKycReviewDate(kycDTO.getLastKycReviewDate());
            kyc.setLastSuitReviewDate(kycDTO.getLastSuitReviewDate());
            kyc.setManualRiskClass(kycDTO.getManualRiskClass());
            kyc.setOverrideReason(kycDTO.getOverrideReason());
            kyc.setRiskAssetType(kycDTO.getRiskAssetType());
            kyc.setRiskFromDate(kycDTO.getRiskFromDate());
            kyc.setRiskLevel(kycDTO.getRiskLevel());
            kyc.setRiskTolerance(kycDTO.getRiskTolerance());
            Kyc savedKyc=kycRepository.save(kyc);
            return dtoMapper.fromKyc(savedKyc);
        }
        return  null;


    }

    @Override
    public KycDTO getKyc(Long kycId) throws KycNotFoundException {
        Kyc kyc=kycRepository.findById(kycId)
                .orElseThrow(()->new KycNotFoundException("Kyc Not Found"));
        return dtoMapper.fromKyc(kyc);
    }

    @Override
    public KycDTO updatekyc(KycDTO kycDTO) {
        log.info("Saving new Kyc");
        Kyc kyc=dtoMapper.fromKycDTO(kycDTO);
        Kyc savedKyc=kycRepository.save(kyc);
        return dtoMapper.fromKyc(savedKyc);
    }

    @Override
    public void deleteKyc(Long kycId) {
        kycRepository.deleteById(kycId);

    }

    @Override
    public List<KycDTO> listKyc() {
        List<Kyc> kycs=kycRepository.findAll();
        List<KycDTO> kycDTOS=kycs.stream().map(kyc -> dtoMapper.fromKyc(kyc)).collect(Collectors.toList());
        return kycDTOS;
    }

    @Override
    public List<KycDTO> searchKyc(String keyword) {
        List<Kyc> kycs=kycRepository.searchKyc(keyword);
        List<KycDTO> kycDTOS=kycs.stream().map(ky->dtoMapper.fromKyc(ky)).collect(Collectors.toList());
        return kycDTOS;
    }
}
