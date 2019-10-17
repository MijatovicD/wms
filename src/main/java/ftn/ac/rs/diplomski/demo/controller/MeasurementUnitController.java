package ftn.ac.rs.diplomski.demo.controller;

import ftn.ac.rs.diplomski.demo.dto.MeasurementUnitDTO;
import ftn.ac.rs.diplomski.demo.entity.MeasurementUnit;
import ftn.ac.rs.diplomski.demo.service.MeasurementUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/unit", produces = "application/json")
@CrossOrigin(value = "http://localhost:4200")
public class MeasurementUnitController {

    @Autowired
    private MeasurementUnitService measurementUnitService;

    @GetMapping(value = {"", "/"}, params = {"page", "size"})
    public ResponseEntity<Page<MeasurementUnitDTO>> getAllPaged(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        Page<MeasurementUnit> units = (Page<MeasurementUnit>) measurementUnitService.findAllPaged(page, size);
        Page<MeasurementUnitDTO> unitDTOS = units.map(MeasurementUnitDTO::new);

        return new ResponseEntity<Page<MeasurementUnitDTO>>(unitDTOS, HttpStatus.OK);
    }

    @PostMapping(value = "/add", consumes = "application/json")
    public ResponseEntity<MeasurementUnitDTO> create(@RequestBody MeasurementUnitDTO measurementUnitDTO){
        System.out.println("DOLAZI VAMO" + measurementUnitDTO);
        MeasurementUnit unit = new MeasurementUnit();
        unit.setName(measurementUnitDTO.getName());

        unit = measurementUnitService.save(unit);

        return new ResponseEntity<>(new MeasurementUnitDTO(unit), HttpStatus.CREATED);
    }
}
