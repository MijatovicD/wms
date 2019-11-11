package ftn.ac.rs.diplomski.demo.controller;

import ftn.ac.rs.diplomski.demo.dto.InventoryDocumentDTO;
import ftn.ac.rs.diplomski.demo.entity.InventoryDocument;
import ftn.ac.rs.diplomski.demo.service.InventoryDocumentService;
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

    @GetMapping(value = {"", "/"}, params = {"page", "size"})
    public ResponseEntity<Page<InventoryDocumentDTO>> getAllPaged(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        Page<InventoryDocument> documents = (Page<InventoryDocument>) documentService.findAllPaged(page, size);
        Page<InventoryDocumentDTO> documentDTOS = documents.map(InventoryDocumentDTO::new);

        return new ResponseEntity<Page<InventoryDocumentDTO>>(documentDTOS, HttpStatus.OK);
    }
}
