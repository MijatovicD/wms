package ftn.ac.rs.diplomski.demo.dto;

import ftn.ac.rs.diplomski.demo.entity.InventoryCommission;

public class InventoryCommissionDTO {

    private Integer id;
    private String name;
    private Boolean president;

    public InventoryCommissionDTO(){

    }

    public InventoryCommissionDTO(Integer id, String name, Boolean president) {
        this.id = id;
        this.name = name;
        this.president = president;
    }

    public InventoryCommissionDTO(InventoryCommission commission){
        this(commission.getId(), commission.getName(), commission.getPresident());
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
