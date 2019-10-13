package ftn.ac.rs.diplomski.demo.dto;

import ftn.ac.rs.diplomski.demo.entity.Product;
import ftn.ac.rs.diplomski.demo.entity.ProductGroup;

public class ProductGroupDTO {

    private Integer id;
    private String name;

    public ProductGroupDTO(){
        super();
    }

    public ProductGroupDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public ProductGroupDTO(ProductGroup productGroup){
        this(productGroup.getId(), productGroup.getName());
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
}
