package ftn.ac.rs.diplomski.demo.controller;

import ftn.ac.rs.diplomski.demo.dto.InventoryCommissionDTO;
import ftn.ac.rs.diplomski.demo.entity.InventoryCommission;
import ftn.ac.rs.diplomski.demo.service.InventoryCommissionService;
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
@RequestMapping("/api/commission")
@CrossOrigin(value = "http://localhost:4200")
public class InventoryCommissionController {

    @Autowired
    private InventoryCommissionService commissionService;


    @GetMapping
    public ResponseEntity<List<InventoryCommissionDTO>> getAll(){
        List<InventoryCommission> commissions = commissionService.findAll();
        List<InventoryCommissionDTO> commissionDTOS = new ArrayList<>();
        for (InventoryCommission i : commissions){
            commissionDTOS.add(new InventoryCommissionDTO(i));
        }

        return new ResponseEntity<>(commissionDTOS, HttpStatus.OK);
    }
}
