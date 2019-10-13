package ftn.ac.rs.diplomski.demo.controller;

import ftn.ac.rs.diplomski.demo.dto.BussinessPartnerDTO;
import ftn.ac.rs.diplomski.demo.entity.BussinessPartner;
import ftn.ac.rs.diplomski.demo.service.BussinesPartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/partner")
public class BussinesPartnerController {

    @Autowired
    private BussinesPartnerService partnerService;

    @GetMapping(value = "/")
    public ResponseEntity<List<BussinessPartnerDTO>> findAll(){
        List<BussinessPartner> partners = partnerService.findAll();
        List<BussinessPartnerDTO> partnerDTOS = new ArrayList<>();
        for (BussinessPartner p : partners){
            partnerDTOS.add(new BussinessPartnerDTO(p));
        }

        return new ResponseEntity<>(partnerDTOS, HttpStatus.OK);
    }
}
