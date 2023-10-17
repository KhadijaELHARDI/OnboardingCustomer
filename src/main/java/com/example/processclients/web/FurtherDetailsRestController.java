package com.example.processclients.web;

import com.example.processclients.dtos.FurtherDetailsDTO;
import com.example.processclients.exceptions.FurtherDetailsNotFoundException;
import com.example.processclients.services.FurtherDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Key;
import java.util.List;

@RestController
@RequestMapping("/furtherDetails")
@AllArgsConstructor
@CrossOrigin("*")
public class FurtherDetailsRestController {
    private FurtherDetailsService furtherDetailsService;
    @PostMapping("/create")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public FurtherDetailsDTO saveFurtherDetailsDTO(@RequestBody FurtherDetailsDTO furtherDetailsDTO){
        return furtherDetailsService.creer(furtherDetailsDTO);
    }
    @PostMapping("/get/{id}")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public FurtherDetailsDTO getFurtherDetails(@PathVariable (name = "id") Long furtherDetailsId) throws FurtherDetailsNotFoundException{
        return furtherDetailsService.getFurtherDetails(furtherDetailsId);
    }
    @PutMapping("/{furtherDetailsId}")
    public FurtherDetailsDTO updateFurtherDetails(@PathVariable Long furtherDetailsId,@RequestBody FurtherDetailsDTO furtherDetailsDTO)
    {
        furtherDetailsDTO.setId(furtherDetailsId);
        return furtherDetailsService.updateFurtherDetails(furtherDetailsDTO);
    }
    @DeleteMapping("/delete/{id}")
    public  void deleteFurtherDetails(@PathVariable Long id){
        furtherDetailsService.deleteFurtherDetails(id);
    }
    @GetMapping("/search")
    public List<FurtherDetailsDTO> searchFurtherDetails(@RequestParam(name = "keyword",defaultValue = "") String keyword){
        return furtherDetailsService.searchFurtherDetails("%"+keyword+"%");
    }
    @GetMapping("/lister")
    public List<FurtherDetailsDTO> listFurtherDetails(){return  furtherDetailsService.listFurtherDetails();}

}
