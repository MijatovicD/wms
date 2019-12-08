package ftn.ac.rs.diplomski.demo.dto;

import ftn.ac.rs.diplomski.demo.entity.InterWarehouseTraffic;

public class InterWarehouseDTO {

    private Integer id;
    private WarehouseDTO originDTO;
    private WarehouseDTO destinationDTO;
    private ProductDTO productDTO;
    private Integer quantity;

    public InterWarehouseDTO(){

    }

    public InterWarehouseDTO(Integer id, WarehouseDTO originDTO, WarehouseDTO destinationDTO, ProductDTO productDTO, Integer quantity) {
        this.id = id;
        this.originDTO = originDTO;
        this.destinationDTO = destinationDTO;
        this.productDTO = productDTO;
        this.quantity = quantity;
    }

    public InterWarehouseDTO(InterWarehouseTraffic traffic){
        this(traffic.getId(), new WarehouseDTO(traffic.getOriginWarehouse()), new WarehouseDTO(traffic.getDestinationWarehouse()), new ProductDTO(traffic.getProduct()), traffic.getQuantity());
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

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "InterWarehouseDTO{" +
                "id=" + id +
                ", originDTO=" + originDTO +
                ", destinationDTO=" + destinationDTO +
                ", productDTO=" + productDTO +
                ", quantity=" + quantity +
                '}';
    }
}
