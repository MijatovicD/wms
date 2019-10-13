package ftn.ac.rs.diplomski.demo.dto;

import ftn.ac.rs.diplomski.demo.entity.Company;

public class CompanyDTO {

    private Integer id;
    private String name;
    private String PIB;
    private String address;
    private PlaceDTO placeDTO;

    public CompanyDTO(){
        super();
    }

    public CompanyDTO(Integer id, String name, String PIB, String address, PlaceDTO placeDTO) {
        this.id = id;
        this.name = name;
        this.PIB = PIB;
        this.address = address;
        this.placeDTO = placeDTO;
    }

    public CompanyDTO(Company company){
        this(company.getId(), company.getName(), company.getPIB(), company.getAddress(), new PlaceDTO(company.getPlace()));
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

    public String getPIB() {
        return PIB;
    }

    public void setPIB(String PIB) {
        this.PIB = PIB;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public PlaceDTO getPlaceDTO() {
        return placeDTO;
    }

    public void setPlaceDTO(PlaceDTO placeDTO) {
        this.placeDTO = placeDTO;
    }
}
