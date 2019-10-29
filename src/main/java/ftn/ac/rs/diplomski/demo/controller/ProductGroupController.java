package ftn.ac.rs.diplomski.demo.controller;

import ftn.ac.rs.diplomski.demo.dto.ProductGroupDTO;
import ftn.ac.rs.diplomski.demo.entity.ProductGroup;
import ftn.ac.rs.diplomski.demo.service.ProductGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/group")
@CrossOrigin(value = "http://localhost:4200")
public class ProductGroupController {

    @Autowired
    private ProductGroupService groupService;


    @GetMapping
    public ResponseEntity<List<ProductGroupDTO>> findAll(){
        List<ProductGroup> productGroups = groupService.findAll();
        List<ProductGroupDTO> dtos = new ArrayList<>();
        for (ProductGroup p : productGroups){
            dtos.add(new ProductGroupDTO(p));
        }

        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }
}
