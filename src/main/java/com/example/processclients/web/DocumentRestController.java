package com.example.processclients.web;

import com.example.processclients.dtos.DocumentDTO;
import com.example.processclients.exceptions.DocumentNotFoundException;
import com.example.processclients.services.DocumentService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/documents")
@AllArgsConstructor
@CrossOrigin("*")
public class DocumentRestController {
    private DocumentService documentService;
    @PostMapping("/create")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public DocumentDTO saveDocument(@RequestBody DocumentDTO documentDTO){
        return documentService.creer(documentDTO);
    }
     @PostMapping("/get/{id}")
     @PreAuthorize("hasAuthority('SCOPE_USER')")
    public DocumentDTO getDocument(@PathVariable (name = "id") Long documentId) throws DocumentNotFoundException{
        return documentService.getDocument(documentId);
    }
    @PutMapping("/{documentId}")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public DocumentDTO updateDocument(@PathVariable Long documentId,@RequestBody DocumentDTO documentDTO){
        documentDTO.setId(documentId);
        return documentService.updateDocument(documentDTO);
    }
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public void deleteDocument(@PathVariable Long id){ documentService.deleteDocument(id);}
    @GetMapping("/search")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public List<DocumentDTO> searchDocument(@RequestParam (name = "keyword",defaultValue = "") String keyword){
        return documentService.searchDocuments("%"+keyword+"%");
    }
    @GetMapping("/lister")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public  List<DocumentDTO> listDocument(){return documentService.listDocuments();}


}
