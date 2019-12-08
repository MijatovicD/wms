package ftn.ac.rs.diplomski.demo.service;

import ftn.ac.rs.diplomski.demo.entity.InterWarehouseTraffic;
import ftn.ac.rs.diplomski.demo.repository.InterWarehouseTrafficRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterWarehouseTrafficService {

    @Autowired
    private InterWarehouseTrafficRepository trafficRepository;

    public List<InterWarehouseTraffic> findAll(){
        return trafficRepository.findAll();
    }

    public InterWarehouseTraffic getOne(Integer id){
        return trafficRepository.getOne(id);
    }
    public InterWarehouseTraffic save(InterWarehouseTraffic traffic){
        return trafficRepository.save(traffic);
    }
}
