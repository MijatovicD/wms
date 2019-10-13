package ftn.ac.rs.diplomski.demo.dto;

import ftn.ac.rs.diplomski.demo.entity.MeasurementUnit;

public class MeasurementUnitDTO {

    private Integer id;
    private String name;

    public MeasurementUnitDTO(){
        super();
    }

    public MeasurementUnitDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public MeasurementUnitDTO(MeasurementUnit measurementUnit){
        this(measurementUnit.getId(), measurementUnit.getName());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
