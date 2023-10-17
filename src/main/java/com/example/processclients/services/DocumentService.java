package com.example.processclients.services;

import com.example.processclients.dtos.ContactDTO;
import com.example.processclients.dtos.DocumentDTO;

import com.example.processclients.exceptions.DocumentNotFoundException;

import java.util.List;

public interface DocumentService {
    DocumentDTO creer(DocumentDTO documentDTO);
    DocumentDTO getDocument(Long documentId) throws DocumentNotFoundException;
    DocumentDTO updateDocument(DocumentDTO documentDTO);
    void deleteDocument(Long documentId);
    List<DocumentDTO> listDocuments();
    List<DocumentDTO> searchDocuments(String keyword);
}
