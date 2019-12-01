package ftn.ac.rs.diplomski.demo.controller;

import ftn.ac.rs.diplomski.demo.dto.InventoryItemDTO;
import ftn.ac.rs.diplomski.demo.entity.InventoryItem;
import ftn.ac.rs.diplomski.demo.service.InventoryDocumentService;
import ftn.ac.rs.diplomski.demo.service.InventoryItemService;
import ftn.ac.rs.diplomski.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/inventoryItem")
@CrossOrigin(value = "http://localhost:4200")
public class InventoryItemController {

    @Autowired
    private InventoryItemService itemService;

    @Autowired
    private ProductService productService;

    @Autowired
    private InventoryDocumentService documentService;

    @GetMapping
    public ResponseEntity<List<InventoryItemDTO>> getAll(){
        List<InventoryItem> items = itemService.findAll();
        List<InventoryItemDTO> itemDTOS = new ArrayList<>();
        for (InventoryItem i : items){
            itemDTOS.add(new InventoryItemDTO(i));
        }
        return new ResponseEntity<>(itemDTOS, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<InventoryItemDTO> add(@RequestBody InventoryItemDTO itemDTO){
        System.out.println("item dto " + itemDTO);
        InventoryItem item = new InventoryItem();
        item.setQuantity(itemDTO.getQuantity());
        item.setProduct(productService.getOne(itemDTO.getProductDTO().getId()));
        item.setInventoryDocument(documentService.getOne(itemDTO.getInventoryDocumentDTO().getId()));

        item = itemService.save(item);

        return new ResponseEntity<>(new InventoryItemDTO(item), HttpStatus.CREATED);
    }

}
