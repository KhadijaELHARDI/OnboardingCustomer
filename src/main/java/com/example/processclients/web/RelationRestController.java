package com.example.processclients.web;

import com.example.processclients.dtos.RelationDTO;
import com.example.processclients.exceptions.RelationNotFoundException;
import com.example.processclients.services.RelationService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/relations")
@AllArgsConstructor
@CrossOrigin("*")
public class RelationRestController {
    private RelationService relationService;
    @PostMapping("/create")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public RelationDTO savedRelation(@RequestBody RelationDTO relationDTO){
        return relationService.creer(relationDTO);
    }
    @PostMapping("/get/{id}")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public RelationDTO getRelation(@PathVariable(name = "id") Long relationId) throws RelationNotFoundException{
        return relationService.getRelation(relationId);
    }
    @PutMapping("/{relationId}")
    public RelationDTO updateRelation(@PathVariable Long relationId,@RequestBody RelationDTO relationDTO){
        relationDTO.setId(relationId);
        return relationService.updateRelation(relationDTO);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteRelation(@PathVariable Long id){relationService.deleteRelation(id);}
    @GetMapping("/search")
    public List<RelationDTO> searchRelation(@RequestParam(name = "keyword",defaultValue = "") String keyword){
        return relationService.searchRelations("%"+keyword+"%");
    }
    @GetMapping("/lister")
    public List<RelationDTO> listRelation(){return relationService.listRelations();}
}
