package ftn.ac.rs.diplomski.demo.service;

import ftn.ac.rs.diplomski.demo.entity.InventoryCommission;
import ftn.ac.rs.diplomski.demo.repository.InventoryCommissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryCommissionService {

    @Autowired
    private InventoryCommissionRepository commissionRepository;


    public List<InventoryCommission> findAll(){
        return commissionRepository.findAll();
    }

//    public List<InventoryCommission> updateByDocumentId(){
//        return commissionRepository.findAllByInventoryDocumentIsNotContaining();
//    }

    public InventoryCommission findById(Integer id){
        return commissionRepository.findById(id).get();
    }

    public InventoryCommission save(InventoryCommission commission){
        return commissionRepository.save(commission);
    }
}
