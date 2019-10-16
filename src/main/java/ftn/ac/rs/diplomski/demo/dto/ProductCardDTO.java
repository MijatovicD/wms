package ftn.ac.rs.diplomski.demo.dto;

import ftn.ac.rs.diplomski.demo.entity.ProductCard;

import java.math.BigInteger;

public class ProductCardDTO {

    private Integer id;
    private double initialStateQuantity;
    private double initialStateValue;
    private double trafficEntryQuantity;
    private double trafficEntryValue;
    private double trafficExitQuantity;
    private double trafficExitValue;
    private double totalQuantity;
    private double totalValue;
    private BussinessYearDTO businessYear;
    private ProductDTO product;
    private WarehouseDTO warehouse;
    private BigInteger price;

    public ProductCardDTO(){
        super();
    }

    public ProductCardDTO(Integer id, double initialStateQuantity, double initialStateValue, double trafficEntryQuantity, double trafficEntryValue, double trafficExitQuantity, double trafficExitValue, double totalQuantity, double totalValue, BussinessYearDTO businessYear, ProductDTO product, WarehouseDTO warehouse, BigInteger price) {
        this.id = id;
        this.initialStateQuantity = initialStateQuantity;
        this.initialStateValue = initialStateValue;
        this.trafficEntryQuantity = trafficEntryQuantity;
        this.trafficEntryValue = trafficEntryValue;
        this.trafficExitQuantity = trafficExitQuantity;
        this.trafficExitValue = trafficExitValue;
        this.totalQuantity = totalQuantity;
        this.totalValue = totalValue;
        this.businessYear = businessYear;
        this.product = product;
        this.warehouse = warehouse;
        this.price = price;
    }

    public ProductCardDTO(ProductCard productCard){
        this(productCard.getId(),
                productCard.getInitStateOfQuantity(),
                productCard.getInitStateOfValue(),
                productCard.getTrafficEntryQuantity(),
                productCard.getTrafficEntryValue(),
                productCard.getTrafficExitQuantity(),
                productCard.getTrafficExitValue(),
                productCard.getTotalAmount(),
                productCard.getTotalValue(),
                new BussinessYearDTO(productCard.getYear()),
                new ProductDTO(productCard.getProduct()),
                new WarehouseDTO(productCard.getWarehouse()),
                productCard.getPrice());
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getInitialStateQuantity() {
        return initialStateQuantity;
    }

    public void setInitialStateQuantity(double initialStateQuantity) {
        this.initialStateQuantity = initialStateQuantity;
    }

    public double getInitialStateValue() {
        return initialStateValue;
    }

    public void setInitialStateValue(double initialStateValue) {
        this.initialStateValue = initialStateValue;
    }

    public double getTrafficEntryQuantity() {
        return trafficEntryQuantity;
    }

    public void setTrafficEntryQuantity(double trafficEntryQuantity) {
        this.trafficEntryQuantity = trafficEntryQuantity;
    }

    public double getTrafficEntryValue() {
        return trafficEntryValue;
    }

    public void setTrafficEntryValue(double trafficEntryValue) {
        this.trafficEntryValue = trafficEntryValue;
    }

    public double getTrafficExitQuantity() {
        return trafficExitQuantity;
    }

    public void setTrafficExitQuantity(double trafficExitQuantity) {
        this.trafficExitQuantity = trafficExitQuantity;
    }

    public double getTrafficExitValue() {
        return trafficExitValue;
    }

    public void setTrafficExitValue(double trafficExitValue) {
        this.trafficExitValue = trafficExitValue;
    }

    public double getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(double totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public BussinessYearDTO getBusinessYear() {
        return businessYear;
    }

    public void setBusinessYear(BussinessYearDTO businessYear) {
        this.businessYear = businessYear;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public WarehouseDTO getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(WarehouseDTO warehouse) {
        this.warehouse = warehouse;
    }

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }
}
