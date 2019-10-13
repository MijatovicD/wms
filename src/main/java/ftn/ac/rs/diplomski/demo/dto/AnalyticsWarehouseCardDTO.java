package ftn.ac.rs.diplomski.demo.dto;

import ftn.ac.rs.diplomski.demo.entity.AnalyticsWarehouseCard;
import ftn.ac.rs.diplomski.demo.entity.AnalyticsWarehouseCard.TrafficDirectionEnum;
import ftn.ac.rs.diplomski.demo.entity.AnalyticsWarehouseCard.TrafficTypeDirectionEnum;

import java.math.BigDecimal;

public class AnalyticsWarehouseCardDTO {

    private Integer id;
    private Integer ordinalNumber;
    private TrafficDirectionEnum trafficDirectionEnum;
    private TrafficTypeDirectionEnum trafficTypeDirectionEnum;
    private double quantity;
    private BigDecimal price;
    private BigDecimal totalValue;
    private ProductCardDTO productCard;
    private  DocumentItemDTO documentItem;

    public AnalyticsWarehouseCardDTO(){
        super();
    }

    public AnalyticsWarehouseCardDTO(Integer id, Integer ordinalNumber, TrafficTypeDirectionEnum trafficTypeDirectionEnum, TrafficDirectionEnum trafficDirectionEnum, double quantity, BigDecimal price, BigDecimal totalValue, ProductCardDTO productCard, DocumentItemDTO documentItem) {
        this.id = id;
        this.ordinalNumber = ordinalNumber;
        this.trafficTypeDirectionEnum = trafficTypeDirectionEnum;
        this.trafficDirectionEnum = trafficDirectionEnum;
        this.quantity = quantity;
        this.price = price;
        this.totalValue = totalValue;
        this.productCard = productCard;
        this.documentItem = documentItem;
    }

    public AnalyticsWarehouseCardDTO(AnalyticsWarehouseCard analyticsWarehouseCard){
        this(analyticsWarehouseCard.getId(),
                analyticsWarehouseCard.getSerialNumber(),
                analyticsWarehouseCard.getTrafficTypeDirectionEnum(),
                analyticsWarehouseCard.getTrafficDirectionEnum(),
                analyticsWarehouseCard.getQuantity(),
                analyticsWarehouseCard.getPrice(),
                analyticsWarehouseCard.getValue(),
                new ProductCardDTO(analyticsWarehouseCard.getProductCard()),
                new DocumentItemDTO(analyticsWarehouseCard.getDocumentItem()));
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrdinalNumber() {
        return ordinalNumber;
    }

    public void setOrdinalNumber(Integer ordinalNumber) {
        this.ordinalNumber = ordinalNumber;
    }

    public TrafficDirectionEnum getTrafficDirectionEnum() {
        return trafficDirectionEnum;
    }

    public void setTrafficDirectionEnum(TrafficDirectionEnum trafficDirectionEnum) {
        this.trafficDirectionEnum = trafficDirectionEnum;
    }

    public TrafficTypeDirectionEnum getTrafficTypeDirectionEnum() {
        return trafficTypeDirectionEnum;
    }

    public void setTrafficTypeDirectionEnum(TrafficTypeDirectionEnum trafficTypeDirectionEnum) {
        this.trafficTypeDirectionEnum = trafficTypeDirectionEnum;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    public ProductCardDTO getProductCard() {
        return productCard;
    }

    public void setProductCard(ProductCardDTO productCard) {
        this.productCard = productCard;
    }

    public DocumentItemDTO getDocumentItem() {
        return documentItem;
    }

    public void setDocumentItem(DocumentItemDTO documentItem) {
        this.documentItem = documentItem;
    }
}
