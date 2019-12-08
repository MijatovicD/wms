package ftn.ac.rs.diplomski.demo.service;

import ftn.ac.rs.diplomski.demo.dto.BussinessYearDTO;
import ftn.ac.rs.diplomski.demo.dto.TrafficDocumentDTO;
import ftn.ac.rs.diplomski.demo.entity.BusinessYear;
import ftn.ac.rs.diplomski.demo.entity.TrafficDocument;
import ftn.ac.rs.diplomski.demo.repository.BussinesYearRepository;
import ftn.ac.rs.diplomski.demo.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BussinesYearServise {

    @Autowired
    private BussinesYearRepository bussinesYearRepository;

    @Autowired
    private DocumentRepository documentRepository;

    public BusinessYear findOne(Integer id){
        return bussinesYearRepository.getOne(id);
    }

    public Page<BusinessYear> findAllPaged(Integer page, Integer size){
        PageRequest pageReq = PageRequest.of(page, size);
        Page<BusinessYear> years = bussinesYearRepository.findAll(pageReq);

        return years;
    }

    public BusinessYear save(BusinessYear year){
        return bussinesYearRepository.save(year);
    }

    public List<TrafficDocumentDTO> getDocumentYear(Integer id){
        List<TrafficDocumentDTO> allDTO = documentRepository.findAll().stream().map(
                documents -> new TrafficDocumentDTO(documents)
        ).collect(Collectors.toList());
        List<TrafficDocumentDTO> documentDTOS = new ArrayList<>();
        for (TrafficDocumentDTO i : allDTO){
            if (i.getBusinessYear().getId() == id){
                documentDTOS.add(i);
            }
        }
        return documentDTOS;
    }

    public boolean zakljuci(BussinessYearDTO yearDTO){
        BusinessYear year = findOne(yearDTO.getId());
        List<TrafficDocumentDTO> documentDTOS = getDocumentYear(yearDTO.getId());

        if(year.isClose() == false){
            year.setClose(true);
            for (TrafficDocumentDTO i : documentDTOS){
                if(i.getStatus() != "Formiranje"){
                    bussinesYearRepository.save(year);
                }
            }
        }
        else{
            return false;
        }

        return false;
    }
}
