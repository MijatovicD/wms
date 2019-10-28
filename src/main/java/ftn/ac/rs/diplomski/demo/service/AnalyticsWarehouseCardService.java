package ftn.ac.rs.diplomski.demo.service;

import ftn.ac.rs.diplomski.demo.entity.AnalyticsWarehouseCard;
import ftn.ac.rs.diplomski.demo.repository.AnalyticsWarehouseCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalyticsWarehouseCardService {

    @Autowired
    private AnalyticsWarehouseCardRepository analyticsWarehouseCardRepository;

    public List<AnalyticsWarehouseCard> findAll(){
        return analyticsWarehouseCardRepository.findAll();
    }

    public AnalyticsWarehouseCard save(AnalyticsWarehouseCard analyticsWarehouseCard){
        return analyticsWarehouseCardRepository.save(analyticsWarehouseCard);
    }

    public List<AnalyticsWarehouseCard> findByProdcutCardId(Integer id){
        return analyticsWarehouseCardRepository.findAllByProductCardId(id);
    }

    public AnalyticsWarehouseCard findByProducCardId(Integer id){
        return analyticsWarehouseCardRepository.findByProductCardId(id);
    }

    public AnalyticsWarehouseCard findByDocumentItemId(Integer id){
        return analyticsWarehouseCardRepository.findAllByDocumentItemId(id);
    }

    public Page<AnalyticsWarehouseCard> findAllPaged(Integer page, Integer size){
        PageRequest pageReq = PageRequest.of(page, size);
        Page<AnalyticsWarehouseCard> analyticsWarehouseCards = analyticsWarehouseCardRepository.findAll(pageReq);

        return analyticsWarehouseCards;
    }
}
