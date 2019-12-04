package ftn.ac.rs.diplomski.demo.dto;

import ftn.ac.rs.diplomski.demo.entity.InventoryCommission;

public class InventoryCommissionDTO {

    private Integer id;
    private String name;
    private Boolean president;
    private InventoryDocumentDTO documentDTO;

    public InventoryCommissionDTO(){

    }

    public InventoryCommissionDTO(Integer id, String name, Boolean president, InventoryDocumentDTO inventoryDocumentDTO) {
        this.id = id;
        this.name = name;
        this.president = president;
        this.documentDTO = inventoryDocumentDTO;
    }

    public InventoryCommissionDTO(InventoryDocumentDTO documentDTO) {
        this.documentDTO = documentDTO;
    }

    public InventoryCommissionDTO(InventoryCommission commission){
        this(commission.getId(), commission.getName(), commission.getPresident(), new InventoryDocumentDTO(commission.getInventoryDocument()));
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

    public Boolean getPresident() {
        return president;
    }

    public void setPresident(Boolean president) {
        this.president = president;
    }

    public InventoryDocumentDTO getDocumentDTO() {
        return documentDTO;
    }

    public void setDocumentDTO(InventoryDocumentDTO documentDTO) {
        this.documentDTO = documentDTO;
    }
}
