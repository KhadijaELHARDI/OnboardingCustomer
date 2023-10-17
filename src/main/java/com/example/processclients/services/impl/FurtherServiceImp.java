package com.example.processclients.services.impl;

import com.example.processclients.dtos.FurtherDetailsDTO;
import com.example.processclients.entities.Customer;
import com.example.processclients.entities.FurtherDetails;
import com.example.processclients.exceptions.FurtherDetailsNotFoundException;
import com.example.processclients.mappers.CustomerMapperImp;
import com.example.processclients.repositories.CustomerRepository;
import com.example.processclients.repositories.FurtherDetailsRepository;
import com.example.processclients.services.FurtherDetailsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class FurtherServiceImp implements FurtherDetailsService {
    private FurtherDetailsRepository furtherDetailsRepository;
    private CustomerMapperImp dtoMapper;
    private final CustomerRepository customerRepository;

    @Override
    public FurtherDetailsDTO creer(FurtherDetailsDTO furtherDetailsDTO) {
        log.info("Saving new FurtherDetails");
        FurtherDetails furtherDetails = new FurtherDetails();
        Customer customer = customerRepository.findById(furtherDetailsDTO.getCustomerId()).orElse(null);
        if (customer != null) {
            furtherDetails.setCustomerId(customer);
            furtherDetails.setChangeDate(furtherDetailsDTO.getChangeDate());
            furtherDetails.setCommType(furtherDetailsDTO.getCommType());
            furtherDetails.setConfidential(furtherDetailsDTO.getConfidential());
            furtherDetails.setCustomerSince(furtherDetailsDTO.getCustomerSince());
            furtherDetails.setFurtherDetails(furtherDetailsDTO.getFurtherDetails());
            furtherDetails.setInterests(furtherDetailsDTO.getInterests());
            furtherDetails.setInternetBanking(furtherDetailsDTO.getInternetBanking());
            furtherDetails.setMobileBanking(furtherDetailsDTO.getMobileBanking());
            furtherDetails.setNoOfDependents(furtherDetailsDTO.getNoOfDependents());
            furtherDetails.setOtherNationality(furtherDetailsDTO.getOtherNationality());
            furtherDetails.setPastimes(furtherDetailsDTO.getPastimes());
            furtherDetails.setPrefChannel(furtherDetailsDTO.getPrefChannel());
            furtherDetails.setPreviousName(furtherDetailsDTO.getPreviousName());
            furtherDetails.setSpokenLanguages(furtherDetailsDTO.getSpokenLanguages());
            FurtherDetails savedFurtherDetails = furtherDetailsRepository.save(furtherDetails);
            return dtoMapper.fromFurtherDetails(savedFurtherDetails);
        }
        return null;


    }

    @Override
    public FurtherDetailsDTO getFurtherDetails(Long furtherDetailsId) throws FurtherDetailsNotFoundException {
        FurtherDetails furtherDetails = furtherDetailsRepository.findById(furtherDetailsId)
                .orElseThrow(() -> new FurtherDetailsNotFoundException("Further Details Not Found"));
        return dtoMapper.fromFurtherDetails(furtherDetails);
    }

    @Override
    public FurtherDetailsDTO updateFurtherDetails(FurtherDetailsDTO furtherDetailsDTO) {
        log.info("Saving new FurtherDetails");
        FurtherDetails furtherDetails = dtoMapper.fromFurtherDetailsDTO(furtherDetailsDTO);
        FurtherDetails savedFurtherDetails = furtherDetailsRepository.save(furtherDetails);
        return dtoMapper.fromFurtherDetails(savedFurtherDetails);
    }

    @Override
    public void deleteFurtherDetails(Long furtherDetailsId) {
        furtherDetailsRepository.deleteById(furtherDetailsId);
    }

    @Override
    public List<FurtherDetailsDTO> listFurtherDetails() {
        List<FurtherDetails> furtherDetailes = furtherDetailsRepository.findAll();
        List<FurtherDetailsDTO> furtherDetailsDTOS = furtherDetailes.stream()
                .map(furtherDetails -> dtoMapper.fromFurtherDetails(furtherDetails))
                .collect(Collectors.toList());
        return furtherDetailsDTOS;
    }

    @Override
    public List<FurtherDetailsDTO> searchFurtherDetails(String keyword) {
        List<FurtherDetails> furtherDetailes = furtherDetailsRepository.searchFurtherDetails(keyword);
        List<FurtherDetailsDTO> furtherDetailsDTOS = furtherDetailes.stream().map(fur -> dtoMapper.fromFurtherDetails(fur)).collect(Collectors.toList());
        return furtherDetailsDTOS;
    }
}
