package com.example.processclients.web;

import com.example.processclients.dtos.KycDTO;
import com.example.processclients.exceptions.KycNotFoundException;
import com.example.processclients.services.KycService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kyc")
@AllArgsConstructor
@CrossOrigin("*")
public class KycRestController {
    private KycService kycService;
    @PostMapping("/create")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public KycDTO savedKyc(@RequestBody KycDTO kycDTO){
        return kycService.creer(kycDTO);
    }
    @PostMapping("/get/{id}")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public KycDTO getKyc(@PathVariable(name ="id") Long kycId) throws KycNotFoundException{
        return kycService.getKyc(kycId);
    }
    @PutMapping("/{kycId}")
    public KycDTO updateKyc(@PathVariable Long kycId,@RequestBody KycDTO kycDTO){
        kycDTO.setId(kycId);
        return kycService.updatekyc(kycDTO);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteKyc(@PathVariable Long id){kycService.deleteKyc(id);}
    @GetMapping("/search")
    public List<KycDTO> searchKyc(@RequestParam(name = "keyword",defaultValue = "") String keyword){
        return kycService.searchKyc("%"+keyword+"%");
    }
    @GetMapping("/lister")
    public List<KycDTO> listKyc(){return kycService.listKyc();}

}
