package ftn.ac.rs.diplomski.demo.service;

import ftn.ac.rs.diplomski.demo.entity.InventoryCommissionDocument;
import ftn.ac.rs.diplomski.demo.repository.CommissionDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommissionDocumentService {

    @Autowired
    private CommissionDocumentRepository commissionDocumentRepository;

    public List<InventoryCommissionDocument> findAll(){
        return commissionDocumentRepository.findAll();
    }

    public InventoryCommissionDocument findOne(Integer id){
        return commissionDocumentRepository.findById(id).get();
    }

//    public List<InventoryCommissionDocument> findByDocumentId(Integer id){
//        return commissionDocumentRepository.findAllByDocument_Id(id);
//    }

    public InventoryCommissionDocument save(InventoryCommissionDocument inventoryCommissionDocument){
        return commissionDocumentRepository.save(inventoryCommissionDocument);
    }
}
