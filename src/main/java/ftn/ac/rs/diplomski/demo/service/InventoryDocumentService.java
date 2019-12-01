package ftn.ac.rs.diplomski.demo.service;

import ftn.ac.rs.diplomski.demo.entity.InventoryDocument;
import ftn.ac.rs.diplomski.demo.repository.InventoryDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryDocumentService {

    @Autowired
    private InventoryDocumentRepository documentRepository;

    public List<InventoryDocument> findAll(){
        return documentRepository.findAll();
    }

    public Page<InventoryDocument> findAllPaged(Integer page, Integer size){
        PageRequest pageReq = PageRequest.of(page, size);
        Page<InventoryDocument> documents = documentRepository.findAll(pageReq);

        return documents;
    }

    public InventoryDocument getOne(Integer id){
        return documentRepository.getOne(id);
    }

    public InventoryDocument save(InventoryDocument inventoryDocument){
        return documentRepository.save(inventoryDocument);
    }
}