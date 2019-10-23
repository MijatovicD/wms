package ftn.ac.rs.diplomski.demo.controller;

import ftn.ac.rs.diplomski.demo.dto.ProductCardDTO;
import ftn.ac.rs.diplomski.demo.dto.WarehouseDTO;
import ftn.ac.rs.diplomski.demo.entity.ProductCard;
import ftn.ac.rs.diplomski.demo.entity.Warehouse;
import ftn.ac.rs.diplomski.demo.repository.ProductCardRepository;
import ftn.ac.rs.diplomski.demo.service.ProductCardService;
import ftn.ac.rs.diplomski.demo.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/warehouse")
@CrossOrigin(value = "http://localhost:4200")
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;

    @Autowired
    private ProductCardService productCardService;

    @GetMapping()
    public ResponseEntity<List<WarehouseDTO>> findAll(){
        List<Warehouse> warehouses = warehouseService.findAll();
        List<WarehouseDTO> warehouseDTOS = new ArrayList<>();
        for (Warehouse w : warehouses){
            warehouseDTOS.add(new WarehouseDTO(w));
        }

        return new ResponseEntity<>(warehouseDTOS, HttpStatus.OK);
    }

    @GetMapping(value = {"", "/"}, params = {"page", "size"})
    public ResponseEntity<Page<WarehouseDTO>> getAllPaged(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        Page<Warehouse> warehouses = (Page<Warehouse>) warehouseService.findAllPaged(page, size);
        Page<WarehouseDTO> partnerDTOS = warehouses.map(WarehouseDTO::new);

        return new ResponseEntity<Page<WarehouseDTO>>(partnerDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}/productCard")
    public ResponseEntity<List<ProductCardDTO>> findByProductCard(@PathVariable("id") Integer id){
        Warehouse warehouse = warehouseService.findOne(id);
        List<ProductCardDTO> productCardDTOS = new ArrayList<>();
        List<ProductCard> productCards = productCardService.findAllByWarehouseId(id);
        for (ProductCard p : productCards){
            productCardDTOS.add(new ProductCardDTO(p));
        }

        return new ResponseEntity<>(productCardDTOS, HttpStatus.OK);
    }
}
