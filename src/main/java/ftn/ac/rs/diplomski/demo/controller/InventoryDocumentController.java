package ftn.ac.rs.diplomski.demo.controller;

import ftn.ac.rs.diplomski.demo.dto.InventoryDocumentDTO;
import ftn.ac.rs.diplomski.demo.entity.InventoryDocument;
import ftn.ac.rs.diplomski.demo.service.BussinesYearServise;
import ftn.ac.rs.diplomski.demo.service.InventoryDocumentService;
import ftn.ac.rs.diplomski.demo.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/inventory")
@CrossOrigin(value = "http://localhost:4200")
public class InventoryDocumentController {


    @Autowired
    private InventoryDocumentService documentService;

    @Autowired
    private WarehouseService warehouseService;

    @Autowired
    private BussinesYearServise yearServise;

    @GetMapping(value = {"", "/"}, params = {"page", "size"})
    public ResponseEntity<Page<InventoryDocumentDTO>> getAllPaged(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        Page<InventoryDocument> documents = (Page<InventoryDocument>) documentService.findAllPaged(page, size);
        Page<InventoryDocumentDTO> documentDTOS = documents.map(InventoryDocumentDTO::new);

        return new ResponseEntity<Page<InventoryDocumentDTO>>(documentDTOS, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<InventoryDocumentDTO> create(@RequestBody InventoryDocumentDTO inventoryDocumentDTO){
        InventoryDocument document = new InventoryDocument();
        document.setFormatDate(inventoryDocumentDTO.getCreateDate());
        document.setBookingDate(inventoryDocumentDTO.getBookingDate());
        document.setStatus(inventoryDocumentDTO.getStatus());
        document.setWarehouse(warehouseService.findOne(inventoryDocumentDTO.getWarehouse().getId()));
        document.setYear(yearServise.findOne(inventoryDocumentDTO.getBusinessYear().getId()));

        document = documentService.save(document);

        return new ResponseEntity<>(new InventoryDocumentDTO(document), HttpStatus.CREATED);
    }
}
