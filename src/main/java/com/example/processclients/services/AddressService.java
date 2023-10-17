package com.example.processclients.services;

import com.example.processclients.dtos.AddressDTO;
import com.example.processclients.dtos.CustomerDTO;
import com.example.processclients.exceptions.AddressNotFoundException;
import com.example.processclients.exceptions.CustomerNotFoundException;

import java.util.List;

public interface AddressService {
    AddressDTO creer(AddressDTO addressDTO);
    AddressDTO getAddress(Long addressId) throws AddressNotFoundException;
    AddressDTO updateAddress(AddressDTO addressDTO);
    void deleteAddress(Long addressId);
    List<AddressDTO> listAddresses();
    List<AddressDTO> searchAddresses(String keyword);
}
