package ftn.ac.rs.diplomski.demo.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "inventoryItem")
public class InventoryItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "inventory_document_id", referencedColumnName = "id")
    private InventoryDocument inventoryDocument;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    public InventoryItem(){

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

    public InventoryDocument getInventoryDocument() {
        return inventoryDocument;
    }

    public void setInventoryDocument(InventoryDocument inventoryDocument) {
        this.inventoryDocument = inventoryDocument;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "InventoryItem{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", inventoryDocument=" + inventoryDocument +
                ", product=" + product +
                '}';
    }
}
