package com.example.processclients.services.impl;

import com.example.processclients.dtos.OtherDetailsDTO;
import com.example.processclients.entities.Customer;
import com.example.processclients.entities.OtherDetails;
import com.example.processclients.exceptions.OtherDetailsNotFoundException;
import com.example.processclients.mappers.CustomerMapperImp;
import com.example.processclients.repositories.CustomerRepository;
import com.example.processclients.repositories.OtherDetailsRepository;
import com.example.processclients.services.OtherDetailsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class OtherDetailsServiceImp implements OtherDetailsService {
    private OtherDetailsRepository otherDetailsRepository;
    private CustomerMapperImp dtoMapper;
     private CustomerRepository customerRepository;
    @Override
    public OtherDetailsDTO creer(OtherDetailsDTO otherDetailsDTO) {
        log.info("Saving new OtherDetails");
        OtherDetails otherDetails=new OtherDetails();
        Customer customer=customerRepository.findById(otherDetailsDTO.getCustomerId()).orElse(null);
        if(customer!=null){
            otherDetails.setCustomerId(customer);
            otherDetails.setCrmUpdate(otherDetailsDTO.getCrmUpdate());
            otherDetails.setBpRequired(otherDetailsDTO.getBpRequired());
            otherDetails.setBranchName(otherDetailsDTO.getBranchName());
            otherDetails.setCrProType(otherDetailsDTO.getCrProType());
            otherDetails.setCrProfile(otherDetailsDTO.getCrProType());
            otherDetails.setExReason(otherDetailsDTO.getExReason());
            otherDetails.setExStatus(otherDetailsDTO.getExStatus());
            otherDetails.setHolPivot(otherDetailsDTO.getHolPivot());
            otherDetails.setIssueCheque(otherDetailsDTO.getIssueCheque());
            otherDetails.setPreviousVisibilityType(otherDetailsDTO.getPreviousVisibilityType());
            otherDetails.setTaxId(otherDetailsDTO.getTaxId());
            otherDetails.setVisComment(otherDetailsDTO.getVisComment());
            otherDetails.setVisReview(otherDetailsDTO.getVisReview());
            otherDetails.setVisibilityType(otherDetailsDTO.getVisibilityType());
            OtherDetails savedOtherDetails=otherDetailsRepository.save(otherDetails);
            return  dtoMapper.fromOtherDetails(savedOtherDetails);


        }
        return  null;


    }

    @Override
    public OtherDetailsDTO getOtherDetails(Long otherDetailsId) throws OtherDetailsNotFoundException {
        OtherDetails otherDetails=otherDetailsRepository.findById(otherDetailsId)
                .orElseThrow(()->new OtherDetailsNotFoundException("OtherDetails Not Found"));
        return dtoMapper.fromOtherDetails(otherDetails);
    }

    @Override
    public OtherDetailsDTO updateOtherDetails(OtherDetailsDTO otherDetailsDTO) {
        log.info("Saving new OtherDetails");
        OtherDetails otherDetails=dtoMapper.fromOtherDetailsDTO(otherDetailsDTO);
        OtherDetails savedOtherDetails=otherDetailsRepository.save(otherDetails);
        return dtoMapper.fromOtherDetails(savedOtherDetails);
    }

    @Override
    public void deleteOtherDetails(Long otherDetailsId) {
        otherDetailsRepository.deleteById(otherDetailsId);

    }

    @Override
    public List<OtherDetailsDTO> listOtherDetails() {
        List<OtherDetails> otherDetailes=otherDetailsRepository.findAll();
        List<OtherDetailsDTO> otherDetailsDTOS=otherDetailes.stream()
                .map(otherDetails->dtoMapper.fromOtherDetails(otherDetails))
                .collect(Collectors.toList());
        return otherDetailsDTOS;
    }

    @Override
    public List<OtherDetailsDTO> searchOtherDetails(String keyword) {
        List<OtherDetails> otherDetailes=otherDetailsRepository.searchOtherDetails(keyword);
        List<OtherDetailsDTO> otherDetailsDTOS=otherDetailes.stream().map(other->dtoMapper.fromOtherDetails(other)).collect(Collectors.toList());

        return otherDetailsDTOS;
    }
}
