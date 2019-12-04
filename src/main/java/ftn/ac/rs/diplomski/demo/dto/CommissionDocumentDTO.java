package ftn.ac.rs.diplomski.demo.dto;


import ftn.ac.rs.diplomski.demo.entity.InventoryCommissionDocument;

public class CommissionDocumentDTO {

    private Integer id;
    private InventoryCommissionDTO inventoryCommissionDTO;
    private InventoryDocumentDTO inventoryDocumentDTO;

    public CommissionDocumentDTO(){

    }

    public CommissionDocumentDTO(Integer id, InventoryCommissionDTO inventoryCommissionDTO, InventoryDocumentDTO inventoryDocumentDTO) {
        this.id = id;
        this.inventoryCommissionDTO = inventoryCommissionDTO;
        this.inventoryDocumentDTO = inventoryDocumentDTO;
    }

    public CommissionDocumentDTO(InventoryCommissionDocument commissionDocument){
        this(commissionDocument.getId(), new InventoryCommissionDTO(commissionDocument.getCommission()), new InventoryDocumentDTO(commissionDocument.getDocument()));
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public InventoryCommissionDTO getInventoryCommissionDTO() {
        return inventoryCommissionDTO;
    }

    public void setInventoryCommissionDTO(InventoryCommissionDTO inventoryCommissionDTO) {
        this.inventoryCommissionDTO = inventoryCommissionDTO;
    }

    public InventoryDocumentDTO getInventoryDocumentDTO() {
        return inventoryDocumentDTO;
    }

    public void setInventoryDocumentDTO(InventoryDocumentDTO inventoryDocumentDTO) {
        this.inventoryDocumentDTO = inventoryDocumentDTO;
    }

    @Override
    public String toString() {
        return "CommissionDocumentDTO{" +
                "id=" + id +
                ", inventoryCommissionDTO=" + inventoryCommissionDTO +
                ", inventoryDocumentDTO=" + inventoryDocumentDTO +
                '}';
    }
}
