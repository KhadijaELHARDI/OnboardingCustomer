package com.example.processclients.services;

import com.example.processclients.dtos.AuditDTO;
import com.example.processclients.dtos.CustomerDTO;
import com.example.processclients.exceptions.AuditNotFoundException;
import com.example.processclients.exceptions.CustomerNotFoundException;

import java.util.List;

public interface AuditService {
    AuditDTO creer(AuditDTO auditDTO);
    AuditDTO getAudit(Long auditId) throws AuditNotFoundException;
    AuditDTO updateAudit(AuditDTO auditDTO);
    void deleteAudit(Long auditId);
    List<AuditDTO> listAudits();
    List<AuditDTO> searchAudits(String keyword);
}
