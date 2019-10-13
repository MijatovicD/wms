package ftn.ac.rs.diplomski.demo.dto;

import ftn.ac.rs.diplomski.demo.entity.Place;

public class PlaceDTO {

    private Integer id;
    private String name;

    public PlaceDTO(){
        super();
    }

    public PlaceDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public PlaceDTO(Place place){
        this(place.getId(), place.getName());
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
