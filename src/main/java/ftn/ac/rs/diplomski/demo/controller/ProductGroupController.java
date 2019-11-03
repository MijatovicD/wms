package ftn.ac.rs.diplomski.demo.controller;

import ftn.ac.rs.diplomski.demo.dto.ProductGroupDTO;
import ftn.ac.rs.diplomski.demo.entity.ProductGroup;
import ftn.ac.rs.diplomski.demo.service.ProductGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = {"", "/"}, params = {"page", "size"})
    public ResponseEntity<Page<ProductGroupDTO>> getAllPaged(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        Page<ProductGroup> groups = (Page<ProductGroup>) groupService.findAllPaged(page, size);
        Page<ProductGroupDTO> groupDTOS = groups.map(ProductGroupDTO::new);

        return new ResponseEntity<Page<ProductGroupDTO>>(groupDTOS, HttpStatus.OK);
    }
}
