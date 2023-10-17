package com.example.processclients.web;

import com.example.processclients.dtos.DocumentDTO;
import com.example.processclients.dtos.FinancialDTO;
import com.example.processclients.exceptions.DocumentNotFoundException;
import com.example.processclients.exceptions.FinancialNotFoundException;
import com.example.processclients.services.FinancialService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/financials")
@AllArgsConstructor
@CrossOrigin("*")
public class FinancialRestController {
    private FinancialService financialService;
    @PostMapping("/create")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public FinancialDTO saveFinancial(@RequestBody FinancialDTO financialDTO){
        return financialService.creer(financialDTO);
    }
    @PostMapping("/get/{id}")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
   public  FinancialDTO getFinancial(@PathVariable(name ="id") Long financialId) throws FinancialNotFoundException{
        return financialService.getFinancial(financialId);
   }
   @PutMapping("/{financialId}")
   @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
   public FinancialDTO updateFinancial(@PathVariable Long financialId,@RequestBody FinancialDTO financialDTO){
        financialDTO.setId(financialId);
        return financialService.updateFinancial(financialDTO);
   }
   @DeleteMapping("/delete/{id}")
   @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
   public void deleteFinancial(@PathVariable Long id){ financialService.deleteFinancial(id);}
    @GetMapping("/search")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public List<FinancialDTO> searchFinancial(@RequestParam(name ="keyword",defaultValue = "") String keyword){
        return financialService.searchFinancial("%"+keyword+"%");
    }
    @GetMapping("/lister")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public List<FinancialDTO> listFinancial(){return  financialService.listFinancials();}
}
