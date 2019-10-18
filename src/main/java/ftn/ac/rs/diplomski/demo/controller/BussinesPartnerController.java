package ftn.ac.rs.diplomski.demo.controller;

import ftn.ac.rs.diplomski.demo.dto.BussinessPartnerDTO;
import ftn.ac.rs.diplomski.demo.entity.BussinessPartner;
import ftn.ac.rs.diplomski.demo.service.BussinesPartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/partner")
@CrossOrigin(value = "http://localhost:4200")
public class BussinesPartnerController {

    @Autowired
    private BussinesPartnerService partnerService;


    @GetMapping()
    public ResponseEntity<List<BussinessPartnerDTO>> findAll(){
        List<BussinessPartner> partners = partnerService.findAll();
        List<BussinessPartnerDTO> partnerDTOS = new ArrayList<>();
        for (BussinessPartner p : partners){
            partnerDTOS.add(new BussinessPartnerDTO(p));
        }

        return new ResponseEntity<>(partnerDTOS, HttpStatus.OK);
    }

    @GetMapping(value = {"", "/"}, params = {"page", "size"})
    public ResponseEntity<Page<BussinessPartnerDTO>> getAllPaged(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        Page<BussinessPartner> partners = (Page<BussinessPartner>) partnerService.findAllPaged(page, size);
        Page<BussinessPartnerDTO> partnerDTOS = partners.map(BussinessPartnerDTO::new);

        return new ResponseEntity<Page<BussinessPartnerDTO>>(partnerDTOS, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BussinessPartnerDTO> create(@RequestBody BussinessPartnerDTO bussinessPartnerDTO){
        System.out.println("dolazi " + bussinessPartnerDTO.toString());
        BussinessPartner partner = new BussinessPartner();
        partner.setName(bussinessPartnerDTO.getName());
        partner.setPIB(bussinessPartnerDTO.getPIB());
        partner.setAddress(bussinessPartnerDTO.getAddress());

        partner = partnerService.save(partner);

        return new ResponseEntity<>(new BussinessPartnerDTO(partner), HttpStatus.CREATED);
    }

    @PutMapping(value = "{/id}")
    public ResponseEntity<BussinessPartnerDTO> update(@RequestBody BussinessPartnerDTO bussinessPartnerDTO, @PathVariable("id") Integer id){
        BussinessPartner partner = partnerService.findOne(id);
        partner.setName(bussinessPartnerDTO.getName());
        partner.setPIB(bussinessPartnerDTO.getPIB());
        partner.setAddress(bussinessPartnerDTO.getAddress());

        partner = partnerService.save(partner);

        return new ResponseEntity<>(new BussinessPartnerDTO(partner), HttpStatus.OK);
    }
}
