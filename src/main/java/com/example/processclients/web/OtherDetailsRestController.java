package com.example.processclients.web;

import com.example.processclients.dtos.OtherDetailsDTO;
import com.example.processclients.exceptions.OtherDetailsNotFoundException;
import com.example.processclients.services.OtherDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/otherDetails")
@AllArgsConstructor
@CrossOrigin("*")
public class OtherDetailsRestController{
    private OtherDetailsService otherDetailsService;
    @PostMapping("/create")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public OtherDetailsDTO savedOtherDetails(@RequestBody OtherDetailsDTO otherDetailsDTO){
        return otherDetailsService.creer(otherDetailsDTO);
    }
    @PostMapping("/get/{id}")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public OtherDetailsDTO getOtherDetails(@PathVariable(name = "id") Long otherDetailsId) throws OtherDetailsNotFoundException {
       return otherDetailsService.getOtherDetails(otherDetailsId);
    }
    @PutMapping("/{otherDetailsId}")
    public OtherDetailsDTO updateOtherDetails(@PathVariable Long otherDetailsId,@RequestBody OtherDetailsDTO otherDetailsDTO){
        otherDetailsDTO.setId(otherDetailsId);
        return otherDetailsService.updateOtherDetails(otherDetailsDTO);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteOtherDetails(@PathVariable Long id){otherDetailsService.deleteOtherDetails(id);}
    @GetMapping("/search")
    public List<OtherDetailsDTO> searchOtherDetails(@RequestParam(name = "keyword",defaultValue = "") String keyword){
        return otherDetailsService.searchOtherDetails("%"+keyword+"%");
    }
    @GetMapping("/lister")
    public List<OtherDetailsDTO> listOtherDetails(){return otherDetailsService.listOtherDetails();}
}

