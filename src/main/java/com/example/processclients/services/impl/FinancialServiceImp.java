package com.example.processclients.services.impl;

import com.example.processclients.dtos.FinancialDTO;
import com.example.processclients.entities.Customer;
import com.example.processclients.entities.Financial;
import com.example.processclients.exceptions.FinancialNotFoundException;
import com.example.processclients.mappers.CustomerMapperImp;
import com.example.processclients.repositories.CustomerRepository;
import com.example.processclients.repositories.FinancialRepository;
import com.example.processclients.services.FinancialService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class FinancialServiceImp implements FinancialService {
    private FinancialRepository financialRepository;
    private final CustomerRepository customerRepository;
    private CustomerMapperImp dtoMapper;
    @Override
    public FinancialDTO creer(FinancialDTO financialDTO) {
        log.info("Saving new Financial");
        Financial financial=new Financial();
        Customer customer=customerRepository.findById(financialDTO.getCustomerId()).orElse(null);
        if(customer!=null){
            financial.setCustomerId(customer);
            financial.setAnnualBonus(financialDTO.getAnnualBonus());
            financial.setCustomerCurrency(financialDTO.getCustomerCurrency());
            financial.setCustomerSalary(financialDTO.getCustomerSalary());
            financial.setEmployersAddress(financialDTO.getEmployersAddress());
            financial.setEmployersBusiness(financialDTO.getEmployersBusiness());
            financial.setEmployersName(financialDTO.getEmployersName());
            financial.setEmploymentStartDt(financialDTO.getEmploymentStartDt());
            financial.setEmploymentStatus(financialDTO.getEmploymentStatus());
            financial.setJobTitle(financialDTO.getJobTitle());
            financial.setNetMonthlyIn(financialDTO.getNetMonthlyIn());
            financial.setNetMonthlyOut(financialDTO.getNetMonthlyOut());
            financial.setOccupation(financialDTO.getOccupation());
            financial.setSalaryDateFrequency(financialDTO.getSalaryDateFrequency());
            Financial savedFinancial=financialRepository.save(financial);
            return dtoMapper.fromFinancial(savedFinancial);
        }
        return null;



    }

    @Override
    public FinancialDTO getFinancial(Long financialId) throws FinancialNotFoundException {
        Financial financial=financialRepository.findById(financialId)
                .orElseThrow(()->new FinancialNotFoundException("Financial Not Found"));
        return dtoMapper.fromFinancial(financial);
    }

    @Override
    public FinancialDTO updateFinancial(FinancialDTO financialDTO) {
        log.info("Saving new Financial");
        Financial financial=dtoMapper.fromFinancialDTO(financialDTO);
        Financial savedFinancial=financialRepository.save(financial);
        return dtoMapper.fromFinancial(savedFinancial);
    }

    @Override
    public void deleteFinancial(Long financialId) {
        financialRepository.deleteById(financialId);
    }

    @Override
    public List<FinancialDTO> listFinancials() {
        List<Financial> financials=financialRepository.findAll();
        List<FinancialDTO> financialDTOS=financials.stream()
                .map(financial -> dtoMapper.fromFinancial(financial))
                .collect(Collectors.toList());
        return financialDTOS;
    }

    @Override
    public List<FinancialDTO> searchFinancial(String keyword) {
        List<Financial> financials=financialRepository.searchFinancial(keyword);
        List<FinancialDTO> financialDTOS=financials.stream().map(fina->dtoMapper.fromFinancial(fina)).collect(Collectors.toList());
        return financialDTOS;
    }
}
