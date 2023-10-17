package com.example.processclients.services;


import com.example.processclients.dtos.FinancialDTO;
import com.example.processclients.exceptions.FinancialNotFoundException;

import java.util.List;

public interface FinancialService {
    FinancialDTO creer(FinancialDTO financialDTO);
    FinancialDTO getFinancial(Long financialId) throws FinancialNotFoundException;
    FinancialDTO updateFinancial(FinancialDTO financialDTO);
    void deleteFinancial(Long financialId);
    List<FinancialDTO> listFinancials();
    List<FinancialDTO> searchFinancial(String keyword);

}
