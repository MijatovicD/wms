package ftn.ac.rs.diplomski.demo.dto;

import ftn.ac.rs.diplomski.demo.entity.InventoryItem;
import ftn.ac.rs.diplomski.demo.entity.Product;

public class InventoryItemDTO {

    private Integer id;
    private Integer quantity;
    private InventoryDocumentDTO inventoryDocumentDTO;
    private Product productDTO;



    public InventoryItemDTO(Integer id, Integer quantity, InventoryDocumentDTO inventoryDocumentDTO, Product productDTO) {
        this.id = id;
        this.quantity = quantity;
        this.inventoryDocumentDTO = inventoryDocumentDTO;
        this.productDTO = productDTO;
    }

    public InventoryItemDTO(InventoryItem item){
        this(item.getId(), item.getQuantity(), new InventoryDocumentDTO(item.getInventoryDocument()), item.getProduct());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public InventoryDocumentDTO getInventoryDocumentDTO() {
        return inventoryDocumentDTO;
    }

    public void setInventoryDocumentDTO(InventoryDocumentDTO inventoryDocumentDTO) {
        this.inventoryDocumentDTO = inventoryDocumentDTO;
    }

    public Product getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(Product productDTO) {
        this.productDTO = productDTO;
    }

    @Override
    public String toString() {
        return "InventoryItemDTO{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", inventoryDocumentDTO=" + inventoryDocumentDTO +
                ", productDTO=" + productDTO +
                '}';
    }
}
