package ftn.ac.rs.diplomski.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "commision")
public class InventoryCommission implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "president")
    private Boolean president;

    @ManyToOne
    @JoinColumn(name = "inventory_document_id", referencedColumnName = "id")
    private InventoryDocument inventoryDocument;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "commission")
    private List<InventoryCommissionDocument> commission = new ArrayList<>();

    public InventoryCommission(){

    }

    public InventoryCommission(String name, Boolean president, InventoryDocument inventoryDocument) {
        this.name = name;
        this.president = president;
        this.inventoryDocument = inventoryDocument;
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

    public InventoryDocument getInventoryDocument() {
        return inventoryDocument;
    }

    public void setInventoryDocument(InventoryDocument inventoryDocument) {
        this.inventoryDocument = inventoryDocument;
    }

    public Boolean getPresident() {
        return president;
    }

    public void setPresident(Boolean president) {
        this.president = president;
    }

    @Override
    public String toString() {
        return "InventoryCommission{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", president=" + president +
                ", inventoryDocument=" + inventoryDocument +
                '}';
    }
}