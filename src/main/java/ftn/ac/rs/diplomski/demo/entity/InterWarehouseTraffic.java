package ftn.ac.rs.diplomski.demo.entity;

import ftn.ac.rs.diplomski.demo.dto.InterWarehouseDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "warehouseTraffic")
public class InterWarehouseTraffic implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "origin_warehouse_id", referencedColumnName = "id")
    private Warehouse originWarehouse;

    @ManyToOne
    @JoinColumn(name = "destination_warehouse_id", referencedColumnName = "id")
    private Warehouse destinationWarehouse;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @Column(name = "quantity")
    private Integer quantity;

   @ManyToOne
   @JoinColumn(name = "document_id", referencedColumnName = "id")
   private TrafficDocument trafficDocument;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "documentItem")
    private List<AnalyticsWarehouseCard> cards = new ArrayList<>();


    public InterWarehouseTraffic(){

    }

    public InterWarehouseTraffic(Warehouse originWarehouse, Warehouse destinationWarehouse, Product product, Integer quantity) {
        this.originWarehouse = originWarehouse;
        this.destinationWarehouse = destinationWarehouse;
        this.product = product;
        this.quantity = quantity;
    }

    public InterWarehouseTraffic(Warehouse originWarehouse, Warehouse destinationWarehouse, Product product, Integer quantity, TrafficDocument trafficDocument, List<AnalyticsWarehouseCard> cards) {
        this.originWarehouse = originWarehouse;
        this.destinationWarehouse = destinationWarehouse;
        this.product = product;
        this.quantity = quantity;
        this.trafficDocument = trafficDocument;
        this.cards = cards;
    }

    public InterWarehouseTraffic(InterWarehouseDTO interWarehouseDTO){
        this.id = interWarehouseDTO.getId();
        this.originWarehouse = null;
        this.destinationWarehouse = null;
        this.product = null;
        this.quantity = interWarehouseDTO.getQuantity();
        this.trafficDocument = new TrafficDocument(interWarehouseDTO.getTrafficDocumentDTO());
        this.cards = null;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Warehouse getOriginWarehouse() {
        return originWarehouse;
    }

    public void setOriginWarehouse(Warehouse originWarehouse) {
        this.originWarehouse = originWarehouse;
    }

    public Warehouse getDestinationWarehouse() {
        return destinationWarehouse;
    }

    public void setDestinationWarehouse(Warehouse destinationWarehouse) {
        this.destinationWarehouse = destinationWarehouse;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public TrafficDocument getTrafficDocument() {
        return trafficDocument;
    }

    public void setTrafficDocument(TrafficDocument trafficDocument) {
        this.trafficDocument = trafficDocument;
    }

    public List<AnalyticsWarehouseCard> getCards() {
        return cards;
    }

    public void setCards(List<AnalyticsWarehouseCard> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "InterWarehouseTraffic{" +
                "id=" + id +
                ", originWarehouse=" + originWarehouse +
                ", destinationWarehouse=" + destinationWarehouse +
                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
