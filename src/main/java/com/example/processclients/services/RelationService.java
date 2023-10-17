package com.example.processclients.services;

import com.example.processclients.dtos.OtherDetailsDTO;
import com.example.processclients.dtos.RelationDTO;
import com.example.processclients.exceptions.RelationNotFoundException;

import java.util.List;

public interface RelationService {
    RelationDTO creer(RelationDTO relationDTO);
    RelationDTO getRelation(Long relationId) throws RelationNotFoundException;
    RelationDTO updateRelation(RelationDTO relationDTO);
    void deleteRelation(Long relationId);
    List<RelationDTO> listRelations();
    List<RelationDTO> searchRelations(String keyword);
}
