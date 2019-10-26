package ftn.ac.rs.diplomski.demo.controller;

import ftn.ac.rs.diplomski.demo.dto.ShoppingCartItemDTO;
import ftn.ac.rs.diplomski.demo.entity.ShoppingCartItem;
import ftn.ac.rs.diplomski.demo.entity.User;
import ftn.ac.rs.diplomski.demo.service.ProductService;
import ftn.ac.rs.diplomski.demo.service.ShoppingCartItemService;
import ftn.ac.rs.diplomski.demo.service.ShoppingCartService;
import ftn.ac.rs.diplomski.demo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/cartItem")
public class ShoppingCartItemController {

    @Autowired
    private ShoppingCartItemService itemService;

    @Autowired
    private ProductService productService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private ShoppingCartService cartService;

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<List<ShoppingCartItemDTO>> findByUserId(@PathVariable("id") Integer id){
        List<ShoppingCartItem> items = itemService.findByUserId(id);
        List<ShoppingCartItemDTO> itemDTOS = new ArrayList<>();
        for (ShoppingCartItem i : items){
            itemDTOS.add(new ShoppingCartItemDTO(i));
        }

        return new ResponseEntity<>(itemDTOS, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<ShoppingCartItemDTO> save(@RequestBody ShoppingCartItemDTO shoppingCartItemDTO){
        ShoppingCartItem cartItem = new ShoppingCartItem();
        cartItem.setProduct(productService.getOne(shoppingCartItemDTO.getProductDTO().getId()));
        User u = usersService.findByUsername(shoppingCartItemDTO.getUserDTO().getUsername());
        cartItem.setUser(usersService.findById(u.getId()));
        cartItem.setShoppingCart(cartService.findById(shoppingCartItemDTO.getShoppingCart().getId()));
        cartItem.setQuantity(shoppingCartItemDTO.getQuantity());

        cartItem = itemService.save(cartItem);

        return new ResponseEntity<>(new ShoppingCartItemDTO(cartItem), HttpStatus.CREATED);
    }
}
