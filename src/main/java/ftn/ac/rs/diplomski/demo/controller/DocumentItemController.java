package ftn.ac.rs.diplomski.demo.controller;

import ftn.ac.rs.diplomski.demo.dto.DocumentItemDTO;
import ftn.ac.rs.diplomski.demo.dto.TrafficDocumentDTO;
import ftn.ac.rs.diplomski.demo.entity.DocumentItem;
import ftn.ac.rs.diplomski.demo.entity.TrafficDocument;
import ftn.ac.rs.diplomski.demo.service.ProductService;
import ftn.ac.rs.diplomski.demo.service.TrafficDocumentItemService;
import ftn.ac.rs.diplomski.demo.service.TrafficDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/documentItem")
@CrossOrigin(value = "http://localhost:4200")
public class DocumentItemController {

    @Autowired
    private TrafficDocumentService trafficDocumentService;

    @Autowired
    private TrafficDocumentItemService trafficDocumentItemService;

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<DocumentItemDTO>> getAll(){
        List<DocumentItem> items = trafficDocumentItemService.findAll();
        List<DocumentItemDTO> itemDTOS = new ArrayList<>();
        for (DocumentItem i : items){
            itemDTOS.add(new DocumentItemDTO(i));
        }
        return new ResponseEntity<>(itemDTOS, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DocumentItemDTO> create(@RequestBody DocumentItemDTO documentItemDTO){
        System.out.println("Item " + documentItemDTO.toString());
        DocumentItem item = new DocumentItem();
        item.setQuantity(documentItemDTO.getQuantity());
        item.setPrice(documentItemDTO.getPrice());
        item.setValue(documentItemDTO.getValue());
        item.setTrafficDocument(trafficDocumentService.getDocument(documentItemDTO.getDocument().getId()));
        item.setProduct(productService.getOne(documentItemDTO.getProduct().getId()));

        item = trafficDocumentItemService.save(item);

        return new ResponseEntity<>(new DocumentItemDTO(item), HttpStatus.CREATED);
    }

    @PostMapping(value = "/proknjizi")
    public ResponseEntity<TrafficDocumentDTO> proknjizi(@RequestBody TrafficDocumentDTO trafficDocumentDTO){
        if(trafficDocumentService.proknjiziDokument(trafficDocumentDTO)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
