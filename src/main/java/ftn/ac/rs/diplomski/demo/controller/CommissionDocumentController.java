package ftn.ac.rs.diplomski.demo.controller;

import ftn.ac.rs.diplomski.demo.dto.CommissionDocumentDTO;
import ftn.ac.rs.diplomski.demo.entity.InventoryCommission;
import ftn.ac.rs.diplomski.demo.entity.InventoryCommissionDocument;
import ftn.ac.rs.diplomski.demo.service.CommissionDocumentService;
import ftn.ac.rs.diplomski.demo.service.InventoryCommissionService;
import ftn.ac.rs.diplomski.demo.service.InventoryDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/commissionDocument")
@CrossOrigin(value = "http://localhost:4200")
public class CommissionDocumentController {

    @Autowired
    private CommissionDocumentService commissionDocumentService;

    @Autowired
    private InventoryCommissionService commissionService;

    @Autowired
    private InventoryDocumentService documentService;

    @GetMapping
    public ResponseEntity<List<CommissionDocumentDTO>> findAll(){
        List<InventoryCommissionDocument> commissionDocuments = commissionDocumentService.findAll();
        List<CommissionDocumentDTO> documentDTOS = new ArrayList<>();
        for (InventoryCommissionDocument i : commissionDocuments){
            documentDTOS.add(new CommissionDocumentDTO(i));
        }
        return new ResponseEntity<>(documentDTOS, HttpStatus.OK);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<List<CommissionDocumentDTO>> findByDocumentId(@PathVariable("id") Integer id){
//        List<InventoryCommissionDocument> documents = commissionDocumentService.findByDocumentId(id);
//        List<CommissionDocumentDTO> documentDTOS = new ArrayList<>();
//        for (InventoryCommissionDocument i : documents){
//            documentDTOS.add(new CommissionDocumentDTO(i));
//        }
//
//        return new ResponseEntity<>(documentDTOS, HttpStatus.OK);
//    }

    @PostMapping
    public ResponseEntity<CommissionDocumentDTO> save(@RequestBody CommissionDocumentDTO commissionDocumentDTO){
        System.out.println("komisijaaa " + commissionDocumentDTO.toString());
        InventoryCommissionDocument commissionDocument = new InventoryCommissionDocument();
        commissionDocument.setCommission(commissionService.findById(commissionDocumentDTO.getInventoryCommissionDTO().getId()));
        commissionDocument.setDocument(documentService.getOne(commissionDocumentDTO.getInventoryDocumentDTO().getId()));

        commissionDocument = commissionDocumentService.save(commissionDocument);

        return new ResponseEntity<>(new CommissionDocumentDTO(commissionDocument), HttpStatus.CREATED);
    }
}
