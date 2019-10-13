package ftn.ac.rs.diplomski.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "documentItem")
public class DocumentItem implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "quantity", nullable = false)
    private Double quantity;

    @Column(name = "price" , nullable = false, columnDefinition = "Decimal(10,2)")
    private Double price;

    @Column(name = "value", nullable = false, columnDefinition = "Decimal(20,2)")
    private Double value;

    @ManyToOne
    @JoinColumn(name = "document_id", referencedColumnName = "id")
    private TrafficDocument trafficDocument;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "documentItem")
    private List<AnalyticsWarehouseCard> cards = new ArrayList<>();

    public DocumentItem(){

    }

    public DocumentItem(Double quantity, Double price, Double value, TrafficDocument trafficDocument, Product product, List<AnalyticsWarehouseCard> cards) {
        this.quantity = quantity;
        this.price = price;
        this.value = value;
        this.trafficDocument = trafficDocument;
        this.product = product;
        this.cards = cards;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public TrafficDocument getTrafficDocument() {
        return trafficDocument;
    }

    public void setTrafficDocument(TrafficDocument trafficDocument) {
        this.trafficDocument = trafficDocument;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<AnalyticsWarehouseCard> getCards() {
        return cards;
    }

    public void setCards(List<AnalyticsWarehouseCard> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "DocumentItem{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", price=" + price +
                ", value=" + value +
                ", trafficDocument=" + trafficDocument +
                ", product=" + product +
                ", cards=" + cards +
                '}';
    }
}