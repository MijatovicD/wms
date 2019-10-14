package ftn.ac.rs.diplomski.demo.service;

import ftn.ac.rs.diplomski.demo.entity.BusinessYear;
import ftn.ac.rs.diplomski.demo.repository.BussinesYearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class BussinesYearServise {

    @Autowired
    private BussinesYearRepository bussinesYearRepository;

    public Page<BusinessYear> findAllPaged(Integer page, Integer size){
        PageRequest pageReq = PageRequest.of(page, size);
        Page<BusinessYear> years = bussinesYearRepository.findAll(pageReq);

        return years;
    }
}
