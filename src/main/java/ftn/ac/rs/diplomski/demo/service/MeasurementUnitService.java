package ftn.ac.rs.diplomski.demo.service;

import ftn.ac.rs.diplomski.demo.entity.MeasurementUnit;
import ftn.ac.rs.diplomski.demo.repository.MeasurementUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class MeasurementUnitService {

    @Autowired
    private MeasurementUnitRepository measurementUnitRepository;

    public Page<MeasurementUnit> findAllPaged(Integer page, Integer size){
        PageRequest pageReq = PageRequest.of(page, size);
        Page<MeasurementUnit> units = measurementUnitRepository.findAll(pageReq);

        return units;
    }

    public MeasurementUnit save(MeasurementUnit measurementUnit){

        return measurementUnitRepository.save(measurementUnit);
    }
}
