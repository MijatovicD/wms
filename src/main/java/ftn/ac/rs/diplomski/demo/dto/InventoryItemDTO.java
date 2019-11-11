package ftn.ac.rs.diplomski.demo.dto;

import ftn.ac.rs.diplomski.demo.entity.InventoryItem;

public class InventoryItemDTO {

    private Integer id;
    private Integer quantity;
    private InventoryDocumentDTO inventoryDocumentDTO;
    private ProductDTO productDTO;



    public InventoryItemDTO(Integer id, Integer quantity, InventoryDocumentDTO inventoryDocumentDTO, ProductDTO productDTO) {
        this.id = id;
        this.quantity = quantity;
        this.inventoryDocumentDTO = inventoryDocumentDTO;
        this.productDTO = productDTO;
    }

    public InventoryItemDTO(InventoryItem item){
        this(item.getId(), item.getQuantity(), new InventoryDocumentDTO(item.getInventoryDocument()), new ProductDTO(item.getProduct()));
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

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }
}
