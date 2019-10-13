package ftn.ac.rs.diplomski.demo.dto;

import ftn.ac.rs.diplomski.demo.entity.DocumentItem;

public class DocumentItemDTO {

    private Integer id;
    private double quantity;
    private double price;
    private double value;
    private TrafficDocumentDTO document;
    private ProductDTO product;

    public DocumentItemDTO(){
        super();
    }

    public DocumentItemDTO(Integer id, double quantity, double price, double value, TrafficDocumentDTO document, ProductDTO product) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.value = value;
        this.document = document;
        this.product = product;
    }

    public DocumentItemDTO(DocumentItem documentItem){
        this(documentItem.getId(), documentItem.getQuantity(), documentItem.getPrice(), documentItem.getValue(), new TrafficDocumentDTO(documentItem.getTrafficDocument()), new ProductDTO(documentItem.getProduct()));
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public TrafficDocumentDTO getDocument() {
        return document;
    }

    public void setDocument(TrafficDocumentDTO document) {
        this.document = document;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }
}
