package ftn.ac.rs.diplomski.demo.dto;

import ftn.ac.rs.diplomski.demo.entity.ShoppingCartItem;

public class ShoppingCartItemDTO {

    private Integer id;
    private ProductDTO productDTO;
    private ShoppingCartDTO shoppingCart;
    private UserDTO userDTO;
    private Integer quantity;

    public ShoppingCartItemDTO(){

    }

    public ShoppingCartItemDTO(Integer id, ProductDTO productDTO, ShoppingCartDTO shoppingCart, UserDTO userDTO, Integer quantity) {
        this.id = id;
        this.productDTO = productDTO;
        this.shoppingCart = shoppingCart;
        this.userDTO = userDTO;
        this.quantity = quantity;
    }

    public ShoppingCartItemDTO(ShoppingCartItem shoppingCart){
        this(shoppingCart.getId(), new ProductDTO(shoppingCart.getProduct()), new ShoppingCartDTO(shoppingCart.getShoppingCart()), new UserDTO(shoppingCart.getUser()), shoppingCart.getQuantity());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

    public ShoppingCartDTO getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCartDTO shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ShoppingCartItemDTO{" +
                "id=" + id +
                ", productDTO=" + productDTO +
                ", shoppingCart=" + shoppingCart +
                ", userDTO=" + userDTO +
                ", quantity=" + quantity +
                '}';
    }
}
