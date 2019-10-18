package ftn.ac.rs.diplomski.demo.service;

import ftn.ac.rs.diplomski.demo.entity.DocumentItem;
import ftn.ac.rs.diplomski.demo.repository.TrafficDocumentItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrafficDocumentItemService {

    @Autowired
    private TrafficDocumentItemRepository documentItemRepository;

    public DocumentItem findOne(Integer id){
        return documentItemRepository.findById(id).get();
    }

    public List<DocumentItem> findAll(){
        return documentItemRepository.findAll();
    }

    public DocumentItem save(DocumentItem documentItem){
        return documentItemRepository.save(documentItem);
    }
}
