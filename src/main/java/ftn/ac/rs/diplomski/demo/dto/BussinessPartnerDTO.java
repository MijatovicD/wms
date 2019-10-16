package ftn.ac.rs.diplomski.demo.dto;

import ftn.ac.rs.diplomski.demo.entity.BussinessPartner;

public class BussinessPartnerDTO {

    private Integer id;
    private String name;
    private String PIB;
    private String address;
    private PlaceDTO placeDTO;

    public BussinessPartnerDTO(){
        super();
    }

    public BussinessPartnerDTO(Integer id, String name, String PIB, String address) {
        this.id = id;
        this.name = name;
        this.PIB = PIB;
        this.address = address;
    }

    public BussinessPartnerDTO(BussinessPartner partner){
        this(partner.getId(), partner.getName(), partner.getPIB(), partner.getAddress());
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

    @Override
    public String toString() {
        return "BussinessPartnerDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", PIB='" + PIB + '\'' +
                ", address='" + address + '\'' +
                ", placeDTO=" + placeDTO +
                '}';
    }
}
