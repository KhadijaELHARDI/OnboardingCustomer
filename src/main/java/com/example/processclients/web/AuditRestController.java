package com.example.processclients.web;
import com.example.processclients.dtos.AddressDTO;
import com.example.processclients.dtos.AuditDTO;
import com.example.processclients.entities.Audit;
import com.example.processclients.exceptions.AuditNotFoundException;
import com.example.processclients.repositories.AuditRepository;
import com.example.processclients.services.AddressService;
import com.example.processclients.services.AuditService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/audits")
@AllArgsConstructor
@CrossOrigin("*")
public class AuditRestController {
    private AuditService auditService;
    @PostMapping("/create")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public AuditDTO saveAudit(@RequestBody AuditDTO auditDTO){
        return auditService.creer(auditDTO);
    }
    @PostMapping("/get/{id}")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public AuditDTO getAudit(@PathVariable(name = "id") Long auditId) throws AuditNotFoundException{
        return auditService.getAudit(auditId);
    }
    @PutMapping("/{auditId}")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public AuditDTO updateAudit(@PathVariable Long auditId,@RequestBody AuditDTO auditDTO){
        auditDTO.setId(auditId);
        return auditService.updateAudit(auditDTO);
    }
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public void deleteAudit(@PathVariable Long id){auditService.deleteAudit(id);}
    @GetMapping("/search")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public List<AuditDTO> searchAudit(@RequestParam(name = "keyword",defaultValue = "") String keyword){
        return auditService.searchAudits("%"+keyword+"%");
    }
    @GetMapping("/lister")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public  List<AuditDTO> listAudit(){ return auditService.listAudits();}


}
