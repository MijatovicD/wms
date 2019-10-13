package ftn.ac.rs.diplomski.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Entity
@Table(name = "productCard")
public class ProductCard implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "price", unique = false, nullable = false, columnDefinition = "Decimal(10,2)")
    private BigInteger price;

    @Column(name = "initStateOfQuantity", unique = false, nullable = false)
    private Integer initStateOfQuantity;

    @Column(name = "initStateOfValue", unique = false, nullable = false, columnDefinition = "Decimal(10,2)")
    private double initStateOfValue;

    @Column(name = "trafficEntryQuantity" , unique = false, nullable = true)
    private Integer trafficEntryQuantity;

    @Column(name = "trafficEntryValue", unique = false, nullable = true, columnDefinition = "Decimal(10,2)")
    private double trafficEntryValue;

    @Column(name = "trafficExitQuantity", unique = false, nullable = true)
    private Integer trafficExitQuantity;

    @Column(name = "trafficExitValue", unique = false, nullable = true)
    private double trafficExitValue;

    @Column(name = "totalAmount", unique = false, nullable = true)
    private double totalAmount;

    @Column(name = "totalValue", unique = false, nullable = true, columnDefinition = "Decimal(20,2)")
    private double totalValue;

    @ManyToOne()
    @JoinColumn(name = "year_id", nullable = true, referencedColumnName = "id")
    private BusinessYear year;

    @ManyToOne()
    @JoinColumn(name = "product_id", nullable = true, referencedColumnName = "id")
    private Product product;

    @ManyToOne()
    @JoinColumn(name = "warehouse_id", nullable = true, referencedColumnName = "id")
    private Warehouse warehouse;

    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "productCard")
    private List<AnalyticsWarehouseCard> cards = new ArrayList<>();

    public ProductCard(){

    }

    public ProductCard(BigInteger price, Integer initStateOfQuantity, double initStateOfValue, Integer trafficEntryQuantity, double trafficEntryValue, Integer trafficExitQuantity, double trafficExitValue, double totalAmount, double totalValue, BusinessYear year, Product product, Warehouse warehouse, List<AnalyticsWarehouseCard> cards) {
        this.price = price;
        this.initStateOfQuantity = initStateOfQuantity;
        this.initStateOfValue = initStateOfValue;
        this.trafficEntryQuantity = trafficEntryQuantity;
        this.trafficEntryValue = trafficEntryValue;
        this.trafficExitQuantity = trafficExitQuantity;
        this.trafficExitValue = trafficExitValue;
        this.totalAmount = totalAmount;
        this.totalValue = totalValue;
        this.year = year;
        this.product = product;
        this.warehouse = warehouse;
        this.cards = cards;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    public Integer getInitStateOfQuantity() {
        return initStateOfQuantity;
    }

    public void setInitStateOfQuantity(Integer initStateOfQuantity) {
        this.initStateOfQuantity = initStateOfQuantity;
    }

    public double getInitStateOfValue() {
        return initStateOfValue;
    }

    public void setInitStateOfValue(double initStateOfValue) {
        this.initStateOfValue = initStateOfValue;
    }

    public Integer getTrafficEntryQuantity() {
        return trafficEntryQuantity;
    }

    public void setTrafficEntryQuantity(Integer trafficEntryQuantity) {
        this.trafficEntryQuantity = trafficEntryQuantity;
    }

    public double getTrafficEntryValue() {
        return trafficEntryValue;
    }

    public void setTrafficEntryValue(double trafficEntryValue) {
        this.trafficEntryValue = trafficEntryValue;
    }

    public Integer getTrafficExitQuantity() {
        return trafficExitQuantity;
    }

    public void setTrafficExitQuantity(Integer trafficExitQuantity) {
        this.trafficExitQuantity = trafficExitQuantity;
    }

    public double getTrafficExitValue() {
        return trafficExitValue;
    }

    public void setTrafficExitValue(double trafficExitValue) {
        this.trafficExitValue = trafficExitValue;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public BusinessYear getYear() {
        return year;
    }

    public void setYear(BusinessYear year) {
        this.year = year;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public List<AnalyticsWarehouseCard> getCards() {
        return cards;
    }

    public void setCards(List<AnalyticsWarehouseCard> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "ProductCard{" +
                "id=" + id +
                ", price=" + price +
                ", initStateOfQuantity=" + initStateOfQuantity +
                ", initStateOfValue=" + initStateOfValue +
                ", trafficEntryQuantity=" + trafficEntryQuantity +
                ", trafficEntryValue=" + trafficEntryValue +
                ", trafficExitQuantity=" + trafficExitQuantity +
                ", trafficExitValue=" + trafficExitValue +
                ", totalAmount=" + totalAmount +
                ", totalValue=" + totalValue +
                ", year=" + year +
                ", product=" + product +
                ", warehouse=" + warehouse +
                ", cards=" + cards +
                '}';
    }
}
