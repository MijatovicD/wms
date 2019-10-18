package ftn.ac.rs.diplomski.demo.service;

import ftn.ac.rs.diplomski.demo.entity.Warehouse;
import ftn.ac.rs.diplomski.demo.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseService {

    @Autowired
    private WarehouseRepository warehouseRepository;

    public Warehouse findOne(Integer id){
        return warehouseRepository.findById(id).get();
    }

    public List<Warehouse> findAll(){
        return warehouseRepository.findAll();
    }
}
