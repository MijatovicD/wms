package ftn.ac.rs.diplomski.demo.controller;

import ftn.ac.rs.diplomski.demo.dto.ShoppingCartItemDTO;
import ftn.ac.rs.diplomski.demo.entity.ShoppingCartItem;
import ftn.ac.rs.diplomski.demo.entity.User;
import ftn.ac.rs.diplomski.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/cartItem")
@CrossOrigin(value = "http://localhost:4200")
public class ShoppingCartItemController {

    @Autowired
    private ShoppingCartItemService itemService;

    @Autowired
    private ProductService productService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private ShoppingCartService cartService;

    @Autowired
    private ProductCardService productCardService;

    @GetMapping
    public ResponseEntity<List<ShoppingCartItemDTO>> findAll(){
        List<ShoppingCartItem> items = itemService.findAll();
        List<ShoppingCartItemDTO> dtos = new ArrayList<>();
        for (ShoppingCartItem i : items){
            dtos.add(new ShoppingCartItemDTO(i));
        }

        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }
    @GetMapping(value = "/user/{username}")
    public ResponseEntity<List<ShoppingCartItemDTO>> findByUserId(@PathVariable("username") String username){
        User u = usersService.findByUsername(username);
        List<ShoppingCartItem> items = itemService.findByUserId(u.getId());
        List<ShoppingCartItemDTO> itemDTOS = new ArrayList<>();
        for (ShoppingCartItem i : items){
            itemDTOS.add(new ShoppingCartItemDTO(i));
        }

        return new ResponseEntity<>(itemDTOS, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<ShoppingCartItemDTO> save(@RequestBody ShoppingCartItemDTO shoppingCartItemDTO){
        System.out.println("ITEEEMS " + shoppingCartItemDTO.toString());
        ShoppingCartItem cartItem = new ShoppingCartItem();
        cartItem.setProduct(productService.getOne(shoppingCartItemDTO.getProductDTO().getId()));
        User u = usersService.findByUsername(shoppingCartItemDTO.getUserDTO().getUsername());
        cartItem.setUser(usersService.findById(u.getId()));
        cartItem.setShoppingCart(cartService.findById(shoppingCartItemDTO.getShoppingCart().getId()));
        cartItem.setQuantity(shoppingCartItemDTO.getQuantity());

        itemService.save(cartItem);

        cartItem = itemService.saveInCard(cartItem);

        return new ResponseEntity<>(new ShoppingCartItemDTO(cartItem), HttpStatus.CREATED);
    }
}
