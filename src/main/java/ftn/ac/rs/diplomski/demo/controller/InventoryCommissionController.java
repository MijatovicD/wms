package ftn.ac.rs.diplomski.demo.controller;

import ftn.ac.rs.diplomski.demo.dto.InventoryCommissionDTO;
import ftn.ac.rs.diplomski.demo.entity.InventoryCommission;
import ftn.ac.rs.diplomski.demo.service.InventoryCommissionService;
import ftn.ac.rs.diplomski.demo.service.InventoryDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/commission")
@CrossOrigin(value = "http://localhost:4200")
public class InventoryCommissionController {

    @Autowired
    private InventoryCommissionService commissionService;

    @Autowired
    private InventoryDocumentService documentService;


    @GetMapping
    public ResponseEntity<List<InventoryCommissionDTO>> getAll(){
        List<InventoryCommission> commissions = commissionService.findAll();
        List<InventoryCommissionDTO> commissionDTOS = new ArrayList<>();
        for (InventoryCommission i : commissions){
            commissionDTOS.add(new InventoryCommissionDTO(i));
        }

        return new ResponseEntity<>(commissionDTOS, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<List<InventoryCommission>> updateCommissionByInventortyDocument(@PathVariable("id") Integer id){
        List<InventoryCommission> commissions = commissionService.updateByDocumentId();
        System.out.println("Komisija za dokument " + commissions.toString());
        for(InventoryCommission commission : commissions){
            commission.setInventoryDocument(documentService.getOne(id));
            commissionService.save(commission);
        }

        return new ResponseEntity<>(commissions, HttpStatus.OK);

    }
}
