package ftn.ac.rs.diplomski.demo.service;

import ftn.ac.rs.diplomski.demo.entity.ProductGroup;
import ftn.ac.rs.diplomski.demo.repository.ProductGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductGroupService {

    @Autowired
    private ProductGroupRepository groupRepository;

    public List<ProductGroup> findAll(){
        return groupRepository.findAll();
    }

    public ProductGroup findById(Integer id){
        return groupRepository.getOne(id);
    }
}
