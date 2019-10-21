package ftn.ac.rs.diplomski.demo.dto;

import ftn.ac.rs.diplomski.demo.entity.Product;
import ftn.ac.rs.diplomski.demo.entity.ProductCard;

public class ProductDTO {

    private Integer id;
    private String name;
    private ProductGroupDTO productGroupDTO;
    private MeasurementUnitDTO measurementUnitDTO;

    public ProductDTO(){
        super();
    }

    public ProductDTO(Integer id, String name, ProductGroupDTO productGroupDTO, MeasurementUnitDTO measurementUnitDTO) {
        this.id = id;
        this.name = name;
        this.productGroupDTO = productGroupDTO;
        this.measurementUnitDTO = measurementUnitDTO;
    }

    public ProductDTO(Product product){
        this(product.getId(), product.getName(), new ProductGroupDTO(product.getProductGroup()), new MeasurementUnitDTO(product.getMeasurementUnit()));
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

    public ProductGroupDTO getProductGroupDTO() {
        return productGroupDTO;
    }

    public void setProductGroupDTO(ProductGroupDTO productGroupDTO) {
        this.productGroupDTO = productGroupDTO;
    }

    public MeasurementUnitDTO getMeasurementUnitDTO() {
        return measurementUnitDTO;
    }

    public void setMeasurementUnitDTO(MeasurementUnitDTO measurementUnitDTO) {
        this.measurementUnitDTO = measurementUnitDTO;
    }


    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", productGroupDTO=" + productGroupDTO +
                ", measurementUnitDTO=" + measurementUnitDTO +
                '}';
    }
}
