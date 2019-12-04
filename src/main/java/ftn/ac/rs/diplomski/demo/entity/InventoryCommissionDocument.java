package ftn.ac.rs.diplomski.demo.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "commissionDocument")
public class InventoryCommissionDocument implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "commission_id", referencedColumnName = "id")
    private InventoryCommission commission;

    @ManyToOne
    @JoinColumn(name = "document_id", referencedColumnName = "id")
    private InventoryDocument document;


    public InventoryCommissionDocument(){

    }

    public InventoryCommissionDocument(InventoryCommission commission, InventoryDocument document) {
        this.commission = commission;
        this.document = document;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public InventoryCommission getCommission() {
        return commission;
    }

    public void setCommission(InventoryCommission commission) {
        this.commission = commission;
    }

    public InventoryDocument getDocument() {
        return document;
    }

    public void setDocument(InventoryDocument document) {
        this.document = document;
    }

    @Override
    public String toString() {
        return "InventoryCommissionDocument{" +
                "id=" + id +
                ", commission=" + commission +
                ", document=" + document +
                '}';
    }
}