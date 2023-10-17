package com.example.processclients.services.impl;

import com.example.processclients.dtos.AddressDTO;
import com.example.processclients.entities.Address;
import com.example.processclients.entities.Customer;
import com.example.processclients.exceptions.AddressNotFoundException;
import com.example.processclients.exceptions.CustomerNotFoundException;
import com.example.processclients.mappers.CustomerMapperImp;
import com.example.processclients.repositories.AddressRepository;
import com.example.processclients.repositories.CustomerRepository;
import com.example.processclients.services.AddressService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class AddressServiceImp implements AddressService {
    private AddressRepository addressRepository;
    private CustomerMapperImp dtoMapper;
    private final CustomerRepository customerRepository;
    @Override
    @Transactional
    public AddressDTO creer(AddressDTO addressDTO) {
        log.info("Starting creer method...");
      Address address=new Address();
        Long customerId = addressDTO.getCustomerId();
        if (customerId != null){
      Customer customer=customerRepository.findById(addressDTO.getCustomerId()).orElse(null);
      if(customer!=null){
          address.setCustomerId(customer);
          address.setAddress(addressDTO.getAddress());
          address.setAddressCountry(addressDTO.getAddressCountry());
          address.setAddressPurpose(addressDTO.getAddressPurpose());
          address.setAddressType(addressDTO.getAddressType());
          address.setAddressValidatedBy(addressDTO.getAddressValidatedBy());
          address.setBuildingName(addressDTO.getBuildingName());
          address.setBuildingNo(addressDTO.getBuildingNo());
          address.setCountrySubdivision(addressDTO.getCountrySubdivision());
          address.setFlatNo(addressDTO.getFlatNo());
          address.setDepartment(addressDTO.getDepartment());
          address.setPostCode(addressDTO.getPostCode());
          address.setLanguage(addressDTO.getLanguage());
          address.setPoBoxNo(addressDTO.getPoBoxNo());
          address.setDistrictName(addressDTO.getAddressPurpose());
          address.setTownCity(addressDTO.getTownCity());
          address.setTownLocationName(addressDTO.getTownLocationName());
          address.setResidenceSince(addressDTO.getResidenceSince());
          address.setResidenceType(addressDTO.getResidenceType());
          address.setResidenceValue(addressDTO.getResidenceValue());
          address.setUpdatePrevAddress(addressDTO.getUpdatePrevAddress());
          address.setStreet(addressDTO.getStreet());
          address.setMortgageAmount(addressDTO.getMortgageAmount());
          address.setResidenceStatus(addressDTO.getResidenceStatus());
          address.setFloor(addressDTO.getFloor());
          address.setSubDepartment(addressDTO.getSubDepartment());
          address.setCountry(addressDTO.getCountry());
          Address savedAddress=addressRepository.save(address);
          return dtoMapper.fromAddress(savedAddress);
      }}
     return  null;

    }

    @Override
    public AddressDTO getAddress(Long addressId) throws AddressNotFoundException {
        Address address=addressRepository.findById(addressId)
                .orElseThrow(()->new AddressNotFoundException("Address Not Found"));
        return dtoMapper.fromAddress(address);
    }

    @Override
    public AddressDTO updateAddress(AddressDTO addressDTO) {
        log.info("Saving new Address");
        Address address=dtoMapper.fromAddressDT0(addressDTO);
        Address savedAddress=addressRepository.save(address);
        return dtoMapper.fromAddress(savedAddress);
    }

    @Override
    public void deleteAddress(Long addressId) {
        addressRepository.deleteById(addressId);

    }

    @Override
    public List<AddressDTO> listAddresses() {
        List<Address> addresses=addressRepository.findAll();
        List<AddressDTO> addressDTOS=addresses.stream().map(address -> dtoMapper.fromAddress(address))
                .collect(Collectors.toList());
        return addressDTOS;
    }

    @Override
    public List<AddressDTO> searchAddresses(String keyword) {
        List<Address> addresses=addressRepository.searchAddress(keyword);
        List<AddressDTO> addressDTOS=addresses.stream().map(add->dtoMapper.fromAddress(add)).collect(Collectors.toList());

        return addressDTOS;
    }

}
