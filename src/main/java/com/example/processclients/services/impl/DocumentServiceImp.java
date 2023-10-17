package com.example.processclients.services.impl;
import com.example.processclients.dtos.ContactDTO;
import com.example.processclients.dtos.DocumentDTO;
import com.example.processclients.entities.Customer;
import com.example.processclients.entities.Document;
import com.example.processclients.exceptions.DocumentNotFoundException;
import com.example.processclients.mappers.CustomerMapperImp;
import com.example.processclients.repositories.CustomerRepository;
import com.example.processclients.repositories.DocumentRepository;
import com.example.processclients.services.DocumentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class DocumentServiceImp implements DocumentService {
   private DocumentRepository documentRepository;
   private CustomerMapperImp dtoMapper;
   private final CustomerRepository customerRepository;
    @Override
    public DocumentDTO creer(DocumentDTO documentDTO) {
        log.info("Saving new Document");
        Document document=new Document();
        Long customerId = documentDTO.getCustomerId();
        if (customerId != null){
        Customer customer=customerRepository.findById(documentDTO.getCustomerId()).orElse(null);
        if(customer!=null){
            document.setCustomerId(customer);
            document.setExpirationDate(documentDTO.getExpirationDate());
            document.setIssueAuthority(documentDTO.getIssueAuthority());
            document.setIssueCountry(documentDTO.getIssueCountry());
            document.setLegalId(documentDTO.getLegalId());
            document.setNameOnId(documentDTO.getNameOnId());
            document.setDocumentName(documentDTO.getDocumentName());
            document.setIssueDate(documentDTO.getIssueDate());
            Document savedDocument=documentRepository.save(document);
            return dtoMapper.fromDocument(savedDocument);

        }}
        return null;

    }

    @Override
    public DocumentDTO getDocument(Long documentId) throws DocumentNotFoundException {
        Document document=documentRepository.findById(documentId)
                .orElseThrow(()->new DocumentNotFoundException("Document Not Found"));
        return dtoMapper.fromDocument(document);
    }

    @Override
    public DocumentDTO updateDocument(DocumentDTO documentDTO) {
        log.info("Saving new Document");
        Document document=dtoMapper.fromDocumentDTO(documentDTO);
        Document savedDocument=documentRepository.save(document);
        return dtoMapper.fromDocument(savedDocument);
    }

    @Override
    public void deleteDocument(Long documentId) {
        documentRepository.deleteById(documentId);

    }

    @Override
    public List<DocumentDTO> listDocuments() {
        List<Document> documents=documentRepository.findAll();
        List<DocumentDTO> documentDTOS=documents.stream()
                .map(document -> dtoMapper.fromDocument(document))
                .collect(Collectors.toList());
        return documentDTOS;
    }

    @Override
    public List<DocumentDTO> searchDocuments(String keyword) {
        List<Document> documents=documentRepository.searchDocument(keyword);
        List<DocumentDTO> documentDTOS=documents.stream().map(doc->dtoMapper.fromDocument(doc)).collect(Collectors.toList());

        return documentDTOS;
    }
}
