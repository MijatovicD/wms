package ftn.ac.rs.diplomski.demo.service;

import ftn.ac.rs.diplomski.demo.entity.BussinessPartner;
import ftn.ac.rs.diplomski.demo.repository.BussinesPartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BussinesPartnerService {

    @Autowired
    private BussinesPartnerRepository bussinesPartnerRepository;

    public List<BussinessPartner> findAll(){
        return bussinesPartnerRepository.findAll();
    }

}
