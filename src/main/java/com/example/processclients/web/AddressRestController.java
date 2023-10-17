package com.example.processclients.web;

import com.example.processclients.dtos.AddressDTO;

import com.example.processclients.exceptions.AddressNotFoundException;
import com.example.processclients.services.AddressService;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
@AllArgsConstructor
@CrossOrigin("*")
public class AddressRestController {
    private AddressService addressService;
    @PostMapping("/create")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public AddressDTO saveAddress(@RequestBody AddressDTO addressDTO){
        return addressService.creer(addressDTO);
    }
    @PostMapping("/get/{id}")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public AddressDTO  getAddress(@PathVariable(name = "id") Long addressId) throws AddressNotFoundException{
        return addressService.getAddress(addressId);
    }
    @PutMapping("/{addressId}")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public AddressDTO updateAddress(@PathVariable Long addressId,@RequestBody AddressDTO addressDTO){
        addressDTO.setId(addressId);
        return addressService.updateAddress(addressDTO);

    }
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public  void deleteAddress(@PathVariable Long id){addressService.deleteAddress(id);}
    @GetMapping("/search")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public List<AddressDTO> searchAddress(@RequestParam(name="keyword",defaultValue = "") String keyword){
        return addressService.searchAddresses("%"+keyword+"%");
    }
    @GetMapping("/lister")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public List<AddressDTO> ListAddress(){return addressService.listAddresses();}
}
