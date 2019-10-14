package ftn.ac.rs.diplomski.demo.controller;

import ftn.ac.rs.diplomski.demo.dto.CompanyDTO;
import ftn.ac.rs.diplomski.demo.entity.Company;
import ftn.ac.rs.diplomski.demo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping(value = {"", "/"}, params = {"page", "size"})
    public ResponseEntity<Page<CompanyDTO>> getAllPaged(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        Page<Company> companies = (Page<Company>) companyService.findAllPaged(page, size);
        Page<CompanyDTO> companyDTOS = companies.map(CompanyDTO::new);

        return new ResponseEntity<Page<CompanyDTO>>(companyDTOS, HttpStatus.OK);
    }
}