package ftn.ac.rs.diplomski.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", columnDefinition = "VARCHAR(60)", length = 60, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "productGroup_id", referencedColumnName = "id")
    private ProductGroup productGroup;

    @ManyToOne
    @JoinColumn(name = "unit_id", referencedColumnName = "id")
    private MeasurementUnit measurementUnit;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<ProductCard> productCards = new ArrayList<>();

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<DocumentItem> items = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private Set<ShoppingCartItem> shoppingCartItems = new HashSet<ShoppingCartItem>();

    public Product(){

    }

    public Product(String name, ProductGroup productGroup, MeasurementUnit measurementUnit) {
        this.name = name;
        this.productGroup = productGroup;
        this.measurementUnit = measurementUnit;
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

    public ProductGroup getProductGroup() {
        return productGroup;
    }

    public void setProductGroup(ProductGroup productGroup) {
        this.productGroup = productGroup;
    }

    public MeasurementUnit getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(MeasurementUnit measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    public List<ProductCard> getProductCards() {
        return productCards;
    }

    public void setProductCards(List<ProductCard> productCards) {
        this.productCards = productCards;
    }

    public List<DocumentItem> getItems() {
        return items;
    }

    public void setItems(List<DocumentItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", productGroup=" + productGroup +
                ", measurementUnit=" + measurementUnit +
                '}';
    }
}
