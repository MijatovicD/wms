package ftn.ac.rs.diplomski.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "analytics")
public class AnalyticsWarehouseCard implements Serializable {

    public enum TrafficDirectionEnum {
        U, // Ulaz
        I  // Izlaz
    }

    public enum TrafficTypeDirectionEnum {
        PR, // Primka
        OT, // Otpremnica
        MM, // Međumagacinski
        NI, // Nivelacija
        PS, // Početno stanje
        KR  // Korekcija
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "serialNumber", nullable = true)
    private Integer serialNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "vrsta_prometa", nullable = false, length = 2, columnDefinition = "Char(2)")
    private TrafficTypeDirectionEnum trafficTypeDirectionEnum;

    @Enumerated(EnumType.STRING)
    @Column(name = "smer", nullable = false, length = 1, columnDefinition = "Char(1)")
    private TrafficDirectionEnum trafficDirectionEnum;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "price" , nullable = false, columnDefinition = "Decimal(10,2)")
    private BigDecimal price;

    @Column(name = "value", nullable = false, columnDefinition = "Decimal(19,2)")
    private BigDecimal value;

    @ManyToOne() // Analitika magacinske kartice 0..n -> 1..1 Robna kartica
    @JoinColumn(name = "productCard_id", referencedColumnName = "id", nullable = false)
    private ProductCard productCard;

    @ManyToOne()
    @JoinColumn(name = "documentItem_id", referencedColumnName = "id", nullable = true)
    private DocumentItem documentItem;

    public AnalyticsWarehouseCard(){

    }

    public AnalyticsWarehouseCard(Integer serialNumber, TrafficTypeDirectionEnum trafficTypeDirectionEnum, TrafficDirectionEnum trafficDirectionEnum, Integer quantity, BigDecimal price, BigDecimal value, ProductCard productCard, DocumentItem documentItem) {
        this.serialNumber = serialNumber;
        this.trafficTypeDirectionEnum = trafficTypeDirectionEnum;
        this.trafficDirectionEnum = trafficDirectionEnum;
        this.quantity = quantity;
        this.price = price;
        this.value = value;
        this.productCard = productCard;
        this.documentItem = documentItem;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    public TrafficTypeDirectionEnum getTrafficTypeDirectionEnum() {
        return trafficTypeDirectionEnum;
    }

    public void setTrafficTypeDirectionEnum(TrafficTypeDirectionEnum trafficTypeDirectionEnum) {
        this.trafficTypeDirectionEnum = trafficTypeDirectionEnum;
    }

    public TrafficDirectionEnum getTrafficDirectionEnum() {
        return trafficDirectionEnum;
    }

    public void setTrafficDirectionEnum(TrafficDirectionEnum trafficDirectionEnum) {
        this.trafficDirectionEnum = trafficDirectionEnum;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public ProductCard getProductCard() {
        return productCard;
    }

    public void setProductCard(ProductCard productCard) {
        this.productCard = productCard;
    }

    public DocumentItem getDocumentItem() {
        return documentItem;
    }

    public void setDocumentItem(DocumentItem documentItem) {
        this.documentItem = documentItem;
    }

    @Override
    public String toString() {
        return "AnalyticsWarehouseCard{" +
                "id=" + id +
                ", serialNumber=" + serialNumber +
                ", trafficTypeDirectionEnum=" + trafficTypeDirectionEnum +
                ", trafficDirectionEnum=" + trafficDirectionEnum +
                ", quantity=" + quantity +
                ", price=" + price +
                ", value=" + value +
                ", productCard=" + productCard +
                ", documentItem=" + documentItem +
                '}';
    }
}
