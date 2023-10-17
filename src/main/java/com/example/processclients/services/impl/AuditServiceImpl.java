package com.example.processclients.services.impl;
import com.example.processclients.dtos.AuditDTO;
import com.example.processclients.entities.Audit;
import com.example.processclients.entities.Customer;
import com.example.processclients.exceptions.AuditNotFoundException;
import com.example.processclients.mappers.CustomerMapperImp;
import com.example.processclients.repositories.AuditRepository;
import com.example.processclients.repositories.CustomerRepository;
import com.example.processclients.services.AuditService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class AuditServiceImpl implements AuditService {
    private AuditRepository auditRepository;
    private final CustomerRepository customerRepository;
    private CustomerMapperImp dtoMapper;
    @Override
    public AuditDTO creer(AuditDTO auditDTO) {
        Audit audit= new Audit();


        Customer customer = customerRepository.findById(auditDTO.getCustomerId()).orElse(null);
        if (customer!=null){
            audit.setCustomerId(customer);
            audit.setOverride(auditDTO.getOverride());
            audit.setAuthoriser(auditDTO.getAuthoriser());
            audit.setInputter(auditDTO.getInputter());
            audit.setAuditdatetime(auditDTO.getDatetime());
            audit.setCurrentNumber(auditDTO.getCurrentNumber());
            audit.setCompanyCode(auditDTO.getCompanyCode());
            audit.setDepartementcode(auditDTO.getDepartementcode());
            audit.setRecordStatus(auditDTO.getRecordStatus());
            audit.setAuditor(auditDTO.getAuditor());
            audit.setDatetime(auditDTO.getDatetime());
            Audit savedAudit=auditRepository.save(audit);
            return dtoMapper.fromAudit(savedAudit);
        }


        return null;
    }

    @Override
    public AuditDTO getAudit(Long auditId) throws AuditNotFoundException {
        Audit audit=auditRepository.findById(auditId)
                .orElseThrow(()->new AuditNotFoundException("Audit Not Found"));

        return dtoMapper.fromAudit(audit);
    }

    @Override
    public AuditDTO updateAudit(AuditDTO auditDTO) {
        log.info("Saving new Audit");
        Audit audit=dtoMapper.fromAuditDTO(auditDTO);
        Audit savedAudit=auditRepository.save(audit);
        return dtoMapper.fromAudit(savedAudit);
    }

    @Override
    public void deleteAudit(Long auditId) {
        auditRepository.deleteById(auditId);

    }

    @Override
    public List<AuditDTO> listAudits() {
        List<Audit> audits=auditRepository.findAll();
        List<AuditDTO> auditDTOS=audits.stream().map(audit -> dtoMapper.fromAudit(audit))
                .collect(Collectors.toList());
        return auditDTOS;
    }

    @Override
    public List<AuditDTO> searchAudits(String keyword) {
        List<Audit> audits=auditRepository.searchAudit(keyword);
        List<AuditDTO>auditDTOS=audits.stream().map(au->dtoMapper.fromAudit(au)).collect(Collectors.toList());
        return auditDTOS;
    }
}
