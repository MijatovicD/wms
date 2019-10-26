package ftn.ac.rs.diplomski.demo.dto;

import ftn.ac.rs.diplomski.demo.entity.ShoppingCart;

public class ShoppingCartDTO {

    private Integer id;

    public ShoppingCartDTO(){

    }

    public ShoppingCartDTO(Integer id) {
        this.id = id;
    }

    public ShoppingCartDTO(ShoppingCart shoppingCart){
        this.id = shoppingCart.getId();
    }

    public Integer getId() {
        return id;
    }
}
