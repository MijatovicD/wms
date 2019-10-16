package ftn.ac.rs.diplomski.demo.service;

import ftn.ac.rs.diplomski.demo.entity.BussinessPartner;
import ftn.ac.rs.diplomski.demo.repository.BussinesPartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BussinesPartnerService {

    @Autowired
    private BussinesPartnerRepository bussinesPartnerRepository;

    public List<BussinessPartner> findAll(){
        return bussinesPartnerRepository.findAll();
    }

    public Page<BussinessPartner> findAllPaged(Integer page, Integer size){
        PageRequest pageReq = PageRequest.of(page, size);
        Page<BussinessPartner> partners = bussinesPartnerRepository.findAll(pageReq);

        return partners;
    }

    public BussinessPartner save(BussinessPartner partner){

        return bussinesPartnerRepository.save(partner);
    }

    public BussinessPartner findOne(Integer id){
        return bussinesPartnerRepository.findById(id).get();
    }
}
