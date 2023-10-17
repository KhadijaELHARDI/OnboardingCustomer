package com.example.processclients.services.impl;

import com.example.processclients.dtos.RelationDTO;
import com.example.processclients.entities.Customer;
import com.example.processclients.entities.Relation;
import com.example.processclients.exceptions.RelationNotFoundException;
import com.example.processclients.mappers.CustomerMapperImp;
import com.example.processclients.repositories.CustomerRepository;
import com.example.processclients.repositories.RelationRepository;
import com.example.processclients.services.RelationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class RelationServiceImp implements RelationService {
    private RelationRepository relationRepository;
    private CustomerMapperImp dtoMapper;
    private CustomerRepository customerRepository;

    @Override
    public RelationDTO creer(RelationDTO relationDTO) {
        log.info("Saving new Relation");
        Relation relation = new Relation();
        Customer customer = customerRepository.findById(relationDTO.getCustomerId()).orElse(null);
        if (customer != null) {
            relation.setCustomerId(customer);
            relation.setCustomerLiability(relationDTO.getCustomerLiability());
            relation.setMoreRoleInfo(relationDTO.getMoreRoleInfo());
            relation.setRelationCode(relationDTO.getRelationCode());
            relation.setRelationCustomer(relationDTO.getRelationCustomer());
            relation.setRelationDelvOption(relationDTO.getRelationDelvOption());
            relation.setReserveRelation(relationDTO.getReserveRelation());
            relation.setRole(relationDTO.getRole());
            relation.setRoleNotes(relationDTO.getRoleNotes());
            Relation savedRelation = relationRepository.save(relation);
            return dtoMapper.fromRelation(savedRelation);
        }
        return null;

    }

    @Override
    public RelationDTO getRelation(Long relationId) throws RelationNotFoundException {
        Relation relation=relationRepository.findById(relationId)
                .orElseThrow(()->new RelationNotFoundException("Relation Not Found"));
        return dtoMapper.fromRelation(relation);
    }

    @Override
    public RelationDTO updateRelation(RelationDTO relationDTO) {
        log.info("Saving new Relation");
        Relation relation=dtoMapper.fromRelationDTO(relationDTO);
        Relation savedRelation=relationRepository.save(relation);
        return dtoMapper.fromRelation(savedRelation);
    }

    @Override
    public void deleteRelation(Long relationId) {
        relationRepository.deleteById(relationId);

    }

    @Override
    public List<RelationDTO> listRelations() {
        List<Relation>relations=relationRepository.findAll();
        List<RelationDTO> relationDTOS=relations.stream()
                .map(relation -> dtoMapper.fromRelation(relation))
                .collect(Collectors.toList());
        return relationDTOS;
    }

    @Override
    public List<RelationDTO> searchRelations(String keyword) {
        List<Relation> relations=relationRepository.searchRelation(keyword);
        List<RelationDTO> relationDTOS=relations.stream().map(rel->dtoMapper.fromRelation(rel)).collect(Collectors.toList());

        return relationDTOS;
    }
}
