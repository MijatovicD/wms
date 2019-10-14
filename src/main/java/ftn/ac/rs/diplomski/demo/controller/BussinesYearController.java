package ftn.ac.rs.diplomski.demo.controller;

import ftn.ac.rs.diplomski.demo.dto.BussinessYearDTO;
import ftn.ac.rs.diplomski.demo.entity.BusinessYear;
import ftn.ac.rs.diplomski.demo.service.BussinesYearServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/year")
@CrossOrigin(value = "http://localhost:4200")
public class BussinesYearController {

    @Autowired
    private BussinesYearServise bussinesYearServise;

    @GetMapping(value = {"", "/"}, params = {"page", "size"})
    public ResponseEntity<Page<BussinessYearDTO>> getAllPaged(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        Page<BusinessYear> years = (Page<BusinessYear>) bussinesYearServise.findAllPaged(page, size);
        Page<BussinessYearDTO> bussinessYearDTOS = years.map(BussinessYearDTO::new);

        return new ResponseEntity<Page<BussinessYearDTO>>(bussinessYearDTOS, HttpStatus.OK);
    }
}
