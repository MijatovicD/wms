package ftn.ac.rs.diplomski.demo.dto;

import ftn.ac.rs.diplomski.demo.entity.InterWarehouseTraffic;
import ftn.ac.rs.diplomski.demo.entity.Product;

public class InterWarehouseDTO {

    private Integer id;
    private WarehouseDTO originDTO;
    private WarehouseDTO destinationDTO;
    private Product productDTO;
    private Integer quantity;
    private TrafficDocumentDTO trafficDocumentDTO;

    public InterWarehouseDTO(){

    }

    public InterWarehouseDTO(Integer id, WarehouseDTO originDTO, WarehouseDTO destinationDTO, Product productDTO, Integer quantity, TrafficDocumentDTO trafficDocumentDTO) {
        this.id = id;
        this.originDTO = originDTO;
        this.destinationDTO = destinationDTO;
        this.productDTO = productDTO;
        this.quantity = quantity;
        this.trafficDocumentDTO = trafficDocumentDTO;
    }

    public InterWarehouseDTO(InterWarehouseTraffic traffic){
        this(traffic.getId(), new WarehouseDTO(traffic.getOriginWarehouse()), new WarehouseDTO(traffic.getDestinationWarehouse()), traffic.getProduct(), traffic.getQuantity(), new TrafficDocumentDTO(traffic.getTrafficDocument()));
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public WarehouseDTO getOriginDTO() {
        return originDTO;
    }

    public void setOriginDTO(WarehouseDTO originDTO) {
        this.originDTO = originDTO;
    }

    public WarehouseDTO getDestinationDTO() {
        return destinationDTO;
    }

    public void setDestinationDTO(WarehouseDTO destinationDTO) {
        this.destinationDTO = destinationDTO;
    }

    public Product getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(Product productDTO) {
        this.productDTO = productDTO;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public TrafficDocumentDTO getTrafficDocumentDTO() {
        return trafficDocumentDTO;
    }

    public void setTrafficDocumentDTO(TrafficDocumentDTO trafficDocumentDTO) {
        this.trafficDocumentDTO = trafficDocumentDTO;
    }

    @Override
    public String toString() {
        return "InterWarehouseDTO{" +
                "id=" + id +
                ", originDTO=" + originDTO +
                ", destinationDTO=" + destinationDTO +
                ", productDTO=" + productDTO +
                ", quantity=" + quantity +
                ", trafficDocumentDTO=" + trafficDocumentDTO +
                '}';
    }
}
